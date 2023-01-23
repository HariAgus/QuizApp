package com.haw.quizapp.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.haw.quizapp.R

@Composable
fun MainScreen() {
    Main()
}

@Composable
fun Main(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_home),
            contentDescription = "Image Background"
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}