package com.androidmodule.kotllincorutineroomapp.data.local

import com.androidmodule.kotllincorutineroomapp.data.local.entity.User

interface DbHelper {

    suspend fun getUsers(): List<User>

    suspend fun insertAll(users: List<User>)

}