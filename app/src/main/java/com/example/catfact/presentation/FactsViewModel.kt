package com.example.catfact.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catfact.domain.FactsInteractor
import com.example.catfact.domain.entity.FactResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class FactsViewModel(private val interactor: FactsInteractor) : ViewModel() {

    private val _facts = MutableStateFlow(listOf<String>())
    val facts = _facts.asStateFlow()

    private var _isError = MutableSharedFlow<String>()
    val isError = _isError.asSharedFlow()

    init {
        getFact()
    }

    fun clearFacts() {
        _facts.value = emptyList()
    }

    fun getFact() {
        viewModelScope.launch {
            interactor.getFact().collect {
                when (it) {
                    is FactResponse.Success -> {
                        val newFact: String = it.data.fact!!
                        _facts.value += newFact
                    }

                    is FactResponse.EmptyListError -> _isError.emit("Error: loaded fact is empty")
                    is FactResponse.FactError -> _isError.emit("Error: network connection is failed")
                }
            }
        }
    }
}



