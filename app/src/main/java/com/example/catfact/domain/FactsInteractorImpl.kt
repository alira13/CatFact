package com.example.catfact.domain

import com.example.catfact.domain.entity.Fact
import com.example.catfact.domain.entity.FactResponse
import kotlinx.coroutines.flow.Flow

class FactsInteractorImpl(private val trackRepository: FactsRepository) : FactsInteractor {
    override fun getFact(): Flow<FactResponse<Fact>> {
        return trackRepository.getFact()
    }
}