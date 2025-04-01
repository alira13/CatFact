package com.example.catfact.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.catfact.R
import com.example.catfact.presentation.FactsViewModel


@Composable
fun FactScreen(viewModel: FactsViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ClearButton("Clear list") { viewModel.clearFacts() }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                FactHeader("Did you know?")
                FactList(viewModel.facts) {
                    viewModel.getFact()
                }
                FactImage(resId = R.drawable.ic_cat, description = "Cat image")
            }
        }
    )
}
