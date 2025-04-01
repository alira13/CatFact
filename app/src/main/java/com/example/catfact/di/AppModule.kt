package com.example.catfact.di

import com.example.catfact.presentation.FactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<FactsViewModel> {
        FactsViewModel(get())
    }
}