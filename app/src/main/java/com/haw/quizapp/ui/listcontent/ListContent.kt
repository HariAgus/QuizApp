package com.haw.quizapp.ui.listcontent

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haw.quizapp.model.Answer
import com.haw.quizapp.model.Content
import com.haw.quizapp.model.Contents
import com.haw.quizapp.ui.component.ItemContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    contents: List<Contents>
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyRow(
                modifier = Modifier.padding(8.dp)
            ) {
                itemsIndexed(contents) { index, content ->
                    ItemContent(
                        modifier = Modifier.fillParentMaxSize(),
                        contents = content,
                        indexPosition = index
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListContentPreview() {
    val contents = ArrayList<Contents>()
    val contentList = ArrayList<Content>().apply {
        add(Content(body = "... Help you?"))
    }
    val answer = ArrayList<Answer>()
    contents.add(Contents(contents = contentList))

    ListContent(contents = contents)
}