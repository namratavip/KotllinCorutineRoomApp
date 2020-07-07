package com.androidmodule.kotllincorutineroomapp.data.api

import com.androidmodule.kotllincorutineroomapp.data.model.ApiUser

interface ApiHelper {
    suspend fun getUsers():List<ApiUser>
}