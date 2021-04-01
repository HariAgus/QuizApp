package com.haw.quizapp.model


import com.google.gson.annotations.SerializedName

data class Answer(
    @SerializedName("answer")
    val answer: String,
    @SerializedName("correct_answer")
    val correctAnswer: Boolean,
    @SerializedName("is_click")
    val isClick: Boolean,
    @SerializedName("option")
    val option: String
)