package com.haw.quizapp.ui.listcontent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.haw.quizapp.model.Contents

@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    contents: List<Contents>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyRow(
        ) {
            items(contents) { content ->

            }
        }
    }
}

@Preview
@Composable
fun ListContentPreview() {
    ListContent(contents = emptyList())
}