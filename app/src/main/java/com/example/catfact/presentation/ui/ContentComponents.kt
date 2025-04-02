package com.example.catfact.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catfact.presentation.FactsViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun FactHeader(text: String) {
    Text(
        text = text, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), fontSize = 24.sp
    )
}

@Composable
fun FactImage(resId: Int, description: String) {
    Image(
        painter = painterResource(resId),
        contentDescription = description,
        modifier = Modifier
            .fillMaxWidth()
            .size(128.dp),
        alignment = Alignment.TopCenter,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondaryContainer)
    )
}

@Composable
fun FactCard(content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = content,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Composable
fun ClearButton(text: String, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            onClick()
        },
        content = {
            Text(text.uppercase())
        }
    )
}

@Composable
fun FactList(viewModel: FactsViewModel) {
    val isRefreshing by viewModel.isLoading.collectAsState()
    val facts by viewModel.facts.collectAsState()
    val onRefresh = { viewModel.getFact() }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = onRefresh
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(facts.count()) { index ->
                FactCard(facts[index])
            }
        }
    }
}