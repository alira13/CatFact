package com.example.catfact.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.catfact.presentation.FactsViewModel
import com.example.catfact.presentation.ui.theme.CatfactTheme


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<FactsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            CatfactTheme(dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FactScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
