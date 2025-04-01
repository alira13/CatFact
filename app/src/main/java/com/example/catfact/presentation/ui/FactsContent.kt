package com.example.catfact.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.catfact.R
import com.example.catfact.presentation.FactsViewModel
import kotlinx.coroutines.launch


@Composable
fun FactScreen(viewModel: FactsViewModel) {
    val scaffoldState = remember{SnackbarHostState()}
    val coroutineScope = rememberCoroutineScope()
    
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState) },

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

                val facts = viewModel.facts.collectAsState(initial = null)
                facts.value?.let { items ->
                    FactList(items) {
                        viewModel.getFact()
                    }
                }

                FactImage(resId = R.drawable.ic_cat, description = "Cat image")
            }
        }
    )

    LaunchedEffect(Unit) {
        viewModel.isError.collect { errorMessage ->
            coroutineScope.launch {
                scaffoldState.showSnackbar(
                    message = errorMessage,
                    actionLabel = "ОК"
                )
            }
        }
    }
}
