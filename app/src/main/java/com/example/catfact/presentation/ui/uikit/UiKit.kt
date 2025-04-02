package com.example.catfact.presentation.ui.uikit

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.catfact.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Preview
@Composable
fun FactHeader(text: String = "Header text") {
    Log.d("RE", "FactHeader")
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding)),
        fontSize = 24.sp
    )
}

@Preview
@Composable
fun FactImage(resId: Int = R.drawable.ic_cat, description: String = "Image description") {
    Log.d("RE", "FactImage")
    Image(
        painter = painterResource(resId),
        contentDescription = description,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding))
            .size(dimensionResource(R.dimen.image_size)),
        alignment = Alignment.TopCenter,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondaryContainer)

    )
}

@Preview
@Composable
fun FactCard(content: String = "Item 1") {
    Log.d("RE", "FactCard")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding))
    ) {
        Text(
            text = content,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding))
        )
    }
}


@Preview
@Composable
fun FactList(
    items: List<String> = listOf("Item 1", "Item 2"),
    isRefreshing: Boolean = false,
    onRefresh: () -> Unit = {}
) {
    Log.d("RE", "FactList")
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = onRefresh
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(items) { item ->
                FactCard(item)
            }
        }
    }
}

@Preview
@Composable
fun FactButton(text: String = "Button".uppercase(), onClick: () -> Unit = {}) {
    Log.d("RE", "FactButton")
    ExtendedFloatingActionButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding)),
        onClick = {
            onClick()
        },
        content = {
            Text(text.uppercase())
        }
    )
}