package com.example.catfact.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.catfact.presentation.FactsViewModel
import com.example.catfact.presentation.ui.theme.CatfactTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<FactsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            CatfactTheme(dynamicColor = false) {
                FactScreen(viewModel)
            }
        }
    }
}
