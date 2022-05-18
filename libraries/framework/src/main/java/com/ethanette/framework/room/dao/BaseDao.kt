package com.ethanette.framework.room.dao

import androidx.room.*

/**
 * # android-template
 * # base dao
 * @author hsjun85
 * @since 2022-05-18
 */
@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<T>)

    @Update
    suspend fun update(data: T)

    @Delete
    suspend fun delete(data: T)

}