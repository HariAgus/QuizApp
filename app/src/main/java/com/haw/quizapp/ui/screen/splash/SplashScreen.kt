package com.haw.quizapp.ui.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.haw.quizapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    val scale = remember { Animatable(0F) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.8F,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4F).getInterpolation(it)
                }
            )
        )
        delay(1200L)
    }

    Splash(scale = scale.value)
}

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    scale: Float
) {
    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.scale(scale),
            painter = painterResource(id = R.drawable.ic_quiz_apps),
            contentDescription = stringResource(R.string.image_logo)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}