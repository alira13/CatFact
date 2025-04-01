package com.example.catfact.data

import com.example.catfact.data.external.FactsNetworkClient
import com.example.catfact.domain.FactsRepository
import com.example.catfact.domain.entity.Fact
import com.example.catfact.domain.entity.FactResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FactsRepositoryImpl(
    private val trackNetworkClient: FactsNetworkClient
) : FactsRepository {

    override fun getFact(): Flow<FactResponse<Fact>> = flow {
        val response = trackNetworkClient.getFact()
        emit(response)
    }
}