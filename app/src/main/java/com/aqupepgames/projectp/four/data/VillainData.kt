package com.aqupepgames.projectp.four.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class VillainData(
    @SerializedName("geo")
    val geo: String,
    @SerializedName("view")
    val view: String,
    @SerializedName("appsChecker")
    val appsChecker: String,
)