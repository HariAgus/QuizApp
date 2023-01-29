package com.haw.quizapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haw.quizapp.model.Answer
import com.haw.quizapp.theme.ColorPrimary
import com.haw.quizapp.utils.DefaultRadioButtonColors

@Composable
fun AnswerCard(
    modifier: Modifier = Modifier,
    answer: Answer,
    index: Int = 0
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(
            width = 1.dp, color = ColorPrimary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(horizontal = 12.dp, vertical = 8.dp))
        ) {
            Card(
                modifier = Modifier.align(Alignment.CenterVertically),
                backgroundColor = ColorPrimary,
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    modifier = Modifier.padding(PaddingValues(horizontal = 12.dp, vertical = 8.dp)),
                    fontSize = 14.sp,
                    text = answer.option.toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1F)
                    .padding(PaddingValues(horizontal = 12.dp)),
                text = answer.answer.toString(),
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                lineHeight = 18.sp
            )

            RadioButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                colors = DefaultRadioButtonColors(
                    selectedColor = Color.Red,
                    unselectedColor = ColorPrimary,
                    disabledColor = ColorPrimary
                ),
                selected = false,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview
@Composable
fun AnswerCardPreview() {
    AnswerCard(
        answer = Answer(
            answer = "First I learn design pattern MVVM, this is a repository wallpapers app which can be used directly for setting the background wallaper on our Smartphone",
            correctAnswer = true,
            option = "A"
        )
    )
}