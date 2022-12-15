package com.aqupepgames.projectp.four.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CodeData(
    @SerializedName("countryCode")
    val countryCode: String,
    @SerializedName("country")
    val country: String
)