package com.example.catfact.data.external.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val TRACK_SEARCH_URL = "https://catfact.ninja"

    private val client: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(TRACK_SEARCH_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: FactsSearchApi by lazy {
        client.create(FactsSearchApi::class.java)
    }
}