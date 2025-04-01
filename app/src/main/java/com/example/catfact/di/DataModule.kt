package com.example.catfact.di

import com.example.catfact.data.FactsRepositoryImpl
import com.example.catfact.data.external.FactsNetworkClient
import com.example.catfact.data.external.FactsNetworkClientImpl
import com.example.catfact.domain.FactsRepository
import org.koin.dsl.module

val dataModule = module {
    single<FactsNetworkClient> {
        FactsNetworkClientImpl()
    }

    single<FactsRepository> {
        FactsRepositoryImpl(get())
    }
}