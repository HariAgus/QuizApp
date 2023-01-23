package com.haw.quizapp.ui.prepare

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haw.quizapp.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PrepareScreen() {
    Prepare(
        onClickStart = {}
    )
}

@Composable
fun Prepare(
    modifier: Modifier = Modifier,
    nickname: String = "",
    onValueChange: (String) -> Unit = {},
    onClickStart: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg_home),
            contentDescription = stringResource(R.string.image_background),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Image(
                modifier = Modifier.padding(top = 140.dp),
                painter = painterResource(id = R.drawable.ic_quiz_apps),
                contentDescription = stringResource(R.string.image_logo)
            )

            Column(
                modifier = Modifier.padding(bottom = 90.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                TextField(
                    value = nickname,
                    onValueChange = {
                        onValueChange.invoke(it)
                    }
                )

                Button(
                    onClick = { onClickStart.invoke() }
                ) {
                    Text(
                        text = stringResource(id = R.string.start),
                        fontFamily = FontFamily.SansSerif,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrepareScreenPreview() {
    PrepareScreen()
}