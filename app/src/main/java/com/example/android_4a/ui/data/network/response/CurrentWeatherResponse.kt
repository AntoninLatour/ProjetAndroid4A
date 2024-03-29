package com.example.android_4a.ui.data.network.response


import com.example.android_4a.ui.data.db.entity.CurrentWeatherEntry
import com.example.android_4a.ui.data.db.entity.Location
import com.example.android_4a.ui.data.db.entity.Request
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val request: Request,
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)