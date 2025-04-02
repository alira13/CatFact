package com.example.catfact.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catfact.domain.FactsInteractor
import com.example.catfact.domain.entity.FactResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FactsViewModel(private val interactor: FactsInteractor) : ViewModel() {
    // для маленького приложения оставила так, вообще делала бы один State
    private val _facts = MutableStateFlow(listOf<String>())
    val facts get() = _facts.asStateFlow()

    private val _isError = MutableSharedFlow<String>()
    val isError get() = _isError.asSharedFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading.asStateFlow()

    init {
        getFact()
    }

    fun clearFacts() {
        _facts.value = emptyList()
    }

    fun getFact() {
        viewModelScope.launch {
            _isLoading.emit(true)
            interactor.getFact().collect {
                when (it) {
                    is FactResponse.Success -> {
                        it.data.fact?.let { fact ->
                            _facts.value += fact
                        }
                    }

                    is FactResponse.EmptyListError -> _isError.emit("Error: loaded fact is empty")
                    is FactResponse.FactError -> _isError.emit("Error: network connection is failed")
                }
            }
            _isLoading.emit(false)
        }
    }
}



