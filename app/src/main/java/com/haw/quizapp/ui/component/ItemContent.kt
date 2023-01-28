package com.haw.quizapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haw.quizapp.R
import com.haw.quizapp.model.Answer
import com.haw.quizapp.model.Content

@Composable
fun ItemContent(
    modifier: Modifier = Modifier,
    content: Content,
    indexPosition: Int = 0
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(PaddingValues(horizontal = 16.dp))
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = content.body.toString(), color = Color.Black,
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image Answer"
        )

        Spacer(modifier = Modifier.height(16.dp))

        AnswerCard(
            modifier = Modifier.fillMaxWidth(),
            answer = content.answers?.get(indexPosition) ?: Answer()
        )
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