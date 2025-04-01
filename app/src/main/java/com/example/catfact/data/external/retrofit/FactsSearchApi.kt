package com.example.catfact.data.external.retrofit

import com.example.catfact.domain.entity.Fact
import retrofit2.http.GET

interface FactsSearchApi {
    @GET("/fact")
    suspend fun getFact(): Fact?
}