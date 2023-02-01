package com.haw.quizapp.ui.listcontent

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haw.quizapp.model.Content
import com.haw.quizapp.model.Contents
import com.haw.quizapp.ui.component.BottomFloatingButton
import com.haw.quizapp.ui.component.ItemContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    content: List<Content>?,
    onClickCloseToolbar: () -> Unit,

    ) {
    Scaffold(
        modifier = modifier,
        topBar = {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        onClickCloseToolbar.invoke()
                    },
                imageVector = Icons.Default.Close,
                colorFilter = ColorFilter.tint(color = Color.Gray),
                contentDescription = "Image Close"
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            BottomFloatingButton(
                currentIndex = content?.size ?: 0,
                totalSize = content?.size ?: 0,
                onClickNext = {},
                onClickPrev = {}
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyRow(
                    modifier = Modifier.padding(8.dp)
                ) {
                    if (content != null) {
                        itemsIndexed(content) { _, content ->
                            ItemContent(
                                modifier = Modifier.fillParentMaxSize(),
                                content = content,
                            )
                        }
                    }
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
    /*val answer = ArrayList<Answer>()
    contents.add(Contents(contents = contentList))

    ListContent(content = contents, onClickCloseToolbar = {})*/
}