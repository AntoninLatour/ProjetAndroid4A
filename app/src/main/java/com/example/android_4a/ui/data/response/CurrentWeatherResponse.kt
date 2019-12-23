package com.example.android_4a.ui.data.response


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val request: Request,
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)