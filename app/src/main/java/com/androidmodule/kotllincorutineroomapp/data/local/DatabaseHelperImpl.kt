package com.androidmodule.kotllincorutineroomapp.data.local

import com.androidmodule.kotllincorutineroomapp.data.local.entity.User

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DbHelper {

    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<User>) = appDatabase.userDao().insertAll(users)

}