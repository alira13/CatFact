package com.example.catfact.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catfact.R
import com.example.catfact.presentation.ui.theme.CatfactTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun FactScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        //Header
        Text(
            text = "Did you know?",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            fontSize = 24.sp
        )

        val facts = mutableListOf<String>()

        var i = 1
        repeat(5) { facts.add("New fact ${i++}") }
        FactList(facts, { facts.add("New fact ${i++}") })

        //Image
        Image(
            painter = painterResource(R.drawable.ic_cat),
            contentDescription = "Cat image",
            modifier = Modifier
                .fillMaxWidth()
                .size(128.dp),
            alignment = Alignment.TopCenter,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
        )
    }

    //Button
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 64.dp)
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
                .fillMaxWidth(),

            onClick = { },
            content = {
                Text("Clear facts".uppercase())
            })
    }
}

@Composable
fun FactList(facts: List<String>, onRefresh: () -> Unit) {
    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(isRefreshing) {
        if (isRefreshing) {
            onRefresh()
            isRefreshing = false
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { isRefreshing = true }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(facts.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = facts[index],
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        maxLines = 2
                    )
                }
            }
        }
    }
}

@Composable
@PreviewLightDark()
fun FactScreenPreview() {
    CatfactTheme(dynamicColor = false) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            FactScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}


