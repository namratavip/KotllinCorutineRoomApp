package com.androidmodule.kotllincorutineroomapp.data.model

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName

data class ApiUser(
    @NonNull
    @SerializedName("id")
    val id: Int = 0,
    @NonNull
    @SerializedName("name")
    val name: String = "",
    @NonNull
    @SerializedName("email")
    val email: String = "",
    @NonNull
    @SerializedName("avatar")
    val avatar: String = ""
)