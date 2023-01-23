package com.haw.quizapp.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haw.quizapp.R
import com.haw.quizapp.theme.ColorPrimary

@Composable
fun MainScreen(
    onClickPlay: () -> Unit
) {
    Main(
        onClickPlay = { onClickPlay.invoke() }
    )
}

@Composable
fun Main(
    modifier: Modifier = Modifier,
    onClickPlay: () -> Unit
) {
    Surface(
        modifier = modifier.background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_home),
            contentDescription = "Image Background"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp, bottom = 32.dp),
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.ic_quiz_apps),
                    contentDescription = "Image Logo"
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.desc_app),
                    textAlign = TextAlign.Center
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(48.dp)
                    .padding(start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = ColorPrimary),
                shape = RoundedCornerShape(12.dp),
                onClick = { onClickPlay.invoke() }
            ) {
                Text(
                    text = stringResource(id = R.string.play),
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(onClickPlay = {})
}