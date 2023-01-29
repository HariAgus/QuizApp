package com.haw.quizapp.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Content(

    @field:SerializedName("image")
    var image: String? = null,

    @field:SerializedName("answers")
    val answers: List<Answer> = emptyList(),

    @field:SerializedName("body")
    val body: String? = null
) : Parcelable