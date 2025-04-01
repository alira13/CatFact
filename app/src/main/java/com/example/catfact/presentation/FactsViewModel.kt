package com.example.catfact.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.random.Random


class FactsViewModel : ViewModel() {

    var facts by mutableStateOf(listOf<String>())
        private set

    init {
        getFact()
    }

    fun clearFacts() {
        facts = emptyList()
    }

    fun getFact() {
        viewModelScope.launch {
            val newFact = getFactFromUseCase()
            facts = facts + newFact
        }
    }

    private fun getFactFromUseCase(): String {
        val id = Random.nextInt(1, 100)
        return "FactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFactFact$id"
    }
}



