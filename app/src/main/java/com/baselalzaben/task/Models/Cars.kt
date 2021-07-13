package com.baselalzaben.task.Models

import com.google.gson.annotations.SerializedName

data class Cars(
    val id: String,
    val brand: String,
    val constractionYear: String,
    val isUsed: String,
    val imageUrl: String,

) {
    data class CountryInfo(
        val flag: String,
        @SerializedName("_id")
        val id: Int
    )
}