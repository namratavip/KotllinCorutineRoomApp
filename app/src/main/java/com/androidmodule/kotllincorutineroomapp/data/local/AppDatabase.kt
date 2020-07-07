package com.androidmodule.kotllincorutineroomapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.androidmodule.kotllincorutineroomapp.data.local.dao.UserDao
import com.androidmodule.kotllincorutineroomapp.data.local.entity.User

@Database(entities = [User::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}