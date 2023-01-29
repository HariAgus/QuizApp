package com.haw.quizapp.ui.screen.prepare

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haw.quizapp.R
import com.haw.quizapp.theme.ColorPrimary

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PrepareScreen(
    nickname: String,
    onValueChange: (String) -> Unit = {},
    onClickStart: () -> Unit
) {
    Prepare(
        nickname = nickname,
        onValueChange = {
            onValueChange.invoke(it)
        },
        onClickStart = onClickStart
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
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.bg_home),
            contentDescription = stringResource(R.string.image_background),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 200.dp),
                painter = painterResource(id = R.drawable.ic_quiz_apps),
                contentDescription = stringResource(R.string.image_logo)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 90.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(horizontal = 16.dp)),
                    value = nickname,
                    placeholder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            style = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                            text = stringResource(id = R.string.enter_a_nickname),
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif,
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent
                    ),
                    textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center),
                    onValueChange = {
                        onValueChange.invoke(it)
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(horizontal = 16.dp)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = ColorPrimary),
                    shape = RoundedCornerShape(12.dp),
                    onClick = { onClickStart.invoke() }
                ) {
                    Text(
                        modifier = Modifier.padding(6.dp),
                        text = stringResource(id = R.string.start),
                        fontFamily = FontFamily.SansSerif,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrepareScreenPreview() {
    PrepareScreen(nickname = "Hari Agus", onClickStart = {})
}