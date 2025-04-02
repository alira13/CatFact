package com.example.catfact.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.catfact.R
import com.example.catfact.presentation.FactsViewModel
import com.example.catfact.presentation.ui.uikit.FactButton
import com.example.catfact.presentation.ui.uikit.FactHeader
import com.example.catfact.presentation.ui.uikit.FactImage
import com.example.catfact.presentation.ui.uikit.FactList
import kotlinx.coroutines.launch


@Composable
fun FactScreen(viewModel: FactsViewModel) {
    Log.d("RE", "FactScreen")
    val scaffoldState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState) },
        modifier = Modifier.fillMaxSize(),

        bottomBar = {
            BottomAppBar(
                containerColor = Color.Transparent,
                tonalElevation = 0.dp
            ) {
                FactButton(stringResource(R.string.lbl_clear_button)) {
                    viewModel.clearFacts()
                }
            }
        },

        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                FactHeader(stringResource(R.string.lbl_header))

                val items by viewModel.facts.collectAsState()
                val isRefreshing by viewModel.isLoading.collectAsState()
                val onRefresh = { viewModel.getFact() }

                FactList(items, isRefreshing, onRefresh)

                FactImage(
                    resId = R.drawable.ic_cat,
                    description = stringResource(R.string.dsc_fact_image)
                )
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
