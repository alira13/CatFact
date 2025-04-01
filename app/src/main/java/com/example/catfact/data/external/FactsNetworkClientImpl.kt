package com.example.catfact.data.external

import com.example.catfact.data.external.retrofit.RetrofitClient
import com.example.catfact.domain.entity.Fact
import com.example.catfact.domain.entity.FactResponse

class FactsNetworkClientImpl : FactsNetworkClient {
    override suspend fun getFact(): FactResponse<Fact> {
        try {
            val response = RetrofitClient.api.getFact()
            return if (response?.fact == null) {
                FactResponse.EmptyListError()
            } else {
                FactResponse.Success(response)
            }
        } catch (ex: Throwable) {
            return FactResponse.FactError()
        }
    }
}