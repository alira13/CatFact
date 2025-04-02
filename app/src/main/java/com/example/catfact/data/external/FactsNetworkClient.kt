package com.example.catfact.data.external

import com.example.catfact.domain.entity.Fact
import com.example.catfact.domain.entity.FactResponse

interface FactsNetworkClient {
    suspend fun getFact(): FactResponse<Fact>
}