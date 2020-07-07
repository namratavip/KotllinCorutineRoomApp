package com.androidmodule.kotllincorutineroomapp.data.api

import com.androidmodule.kotllincorutineroomapp.data.model.ApiUser

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): List<ApiUser> {
        return apiService.getUsers()
    }

}