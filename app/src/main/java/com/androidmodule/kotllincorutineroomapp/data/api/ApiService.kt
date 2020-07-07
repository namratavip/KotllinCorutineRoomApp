package com.androidmodule.kotllincorutineroomapp.data.api

import com.androidmodule.kotllincorutineroomapp.data.model.ApiUser
import retrofit2.http.GET


interface ApiService {
    @GET("users")
    suspend fun getUsers():List<ApiUser>
}