package com.haw.quizapp.model


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("answers")
    val answers: List<Answer>,
    @SerializedName("body")
    val body: String,
    @SerializedName("image")
    val image: String?
)