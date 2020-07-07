package com.androidmodule.kotllincorutineroomapp.data.local.dao

import androidx.room.*

@Dao
abstract class BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract  fun insert(entity: T)

    @Update
    abstract  fun update(entity: T)

    @Delete
    abstract fun delete(entity: T)
}