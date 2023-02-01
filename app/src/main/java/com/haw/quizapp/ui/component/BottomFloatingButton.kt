package com.haw.quizapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haw.quizapp.theme.ColorPrimary

@Composable
fun BottomFloatingButton(
    modifier: Modifier = Modifier,
    currentIndex: Int,
    totalSize: Int,
    onClickNext: () -> Unit,
    onClickPrev: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(PaddingValues(horizontal = 12.dp)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = ColorPrimary),
            shape = CircleShape,
            onClick = { onClickNext.invoke() }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Button Prev",
                tint = Color.White
            )
        }

        Card(
            modifier = Modifier.align(Alignment.CenterVertically),
            shape = RoundedCornerShape(36.dp),
            backgroundColor = ColorPrimary
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "$currentIndex / $totalSize", color = Color.White
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = ColorPrimary),
            shape = CircleShape,
            onClick = { onClickPrev.invoke() }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Button Nex",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomFloatingButtonPreview() {
    BottomFloatingButton(
        currentIndex = 1,
        totalSize = 10,
        onClickNext = {},
        onClickPrev = {}
    )
}