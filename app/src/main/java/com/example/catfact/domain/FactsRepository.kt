package com.example.catfact.domain

import com.example.catfact.domain.entity.Fact
import com.example.catfact.domain.entity.FactResponse
import kotlinx.coroutines.flow.Flow

interface FactsRepository {
    fun getFact(): Flow<FactResponse<Fact>>
}