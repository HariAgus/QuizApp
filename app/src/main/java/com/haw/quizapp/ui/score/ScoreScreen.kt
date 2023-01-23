package com.haw.quizapp.ui.score

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haw.quizapp.R
import com.haw.quizapp.theme.ColorPrimary

@Composable
fun ScoreScreen(
    onClickDone: () -> Unit
) {
    Score(
        onClickDone = onClickDone
    )
}

@Composable
fun Score(
    modifier: Modifier = Modifier,
    onClickDone: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            ButtonFloatingDone(
                onClickDone = onClickDone
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_test_result),
                contentDescription = "Background Score"
            )

            /* Content Score */
            Column(
                modifier = Modifier
                    .offset(y = (-90).dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_test_result),
                    contentDescription = "Background Score"
                )

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.your_score),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(backgroundColor = ColorPrimary),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {}
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        text = "0",
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonFloatingDone(
    modifier: Modifier = Modifier,
    onClickDone: () -> Unit
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = ColorPrimary),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            onClickDone.invoke()
        }
    ) {
        Text(
            text = stringResource(id = R.string.done),
            color = Color.White
        )

        Image(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Button Done",
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}

@Preview
@Composable
fun ScoreScreenPreview() {
    ScoreScreen(onClickDone = {})
}