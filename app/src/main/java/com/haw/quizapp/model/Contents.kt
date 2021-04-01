package com.haw.quizapp.model


import com.google.gson.annotations.SerializedName

data class Contents(
    @SerializedName("contents")
    val contents: List<Content>
)