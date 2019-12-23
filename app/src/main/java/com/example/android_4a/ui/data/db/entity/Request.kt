package com.example.android_4a.ui.data.db.entity


import com.google.gson.annotations.SerializedName

data class Request(
    val type: String,
    val query: String,
    val language: String,
    val unit: String
)