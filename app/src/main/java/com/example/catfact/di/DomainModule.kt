package com.example.catfact.di

import com.example.catfact.domain.FactsInteractor
import com.example.catfact.domain.FactsInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    factory<FactsInteractor> {
        FactsInteractorImpl(get())
    }
}