package com.oybekdev.retrofitapp1.model


import com.google.gson.annotations.SerializedName

data class MarverData(
    val bio: String,
    val createdby: String,
    val firstappearance: String,
    val imageurl: String,
    val name: String,
    val publisher: String,
    val realname: String,
    val team: String
)