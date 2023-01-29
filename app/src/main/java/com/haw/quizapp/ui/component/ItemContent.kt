package com.haw.quizapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haw.quizapp.model.Content

@Composable
fun ItemContent(
    modifier: Modifier = Modifier,
    content: Content,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(PaddingValues(horizontal = 12.dp))
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = content.body.toString(),
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(content.answers) { answer ->
                AnswerCard(
                    modifier = Modifier.fillMaxWidth(),
                    answer = answer
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ItemContentPreview() {
    ItemContent(
        content = Content(
            body = "First I learn design pattern MVVM, this is a repository wallpapers app which can be used directly for setting the background wallaper on our Smartphone"
        )
    )
}