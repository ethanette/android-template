package com.ethanette.data.local.sample.dao

import androidx.room.Dao
import androidx.room.Query
import com.ethanette.data.local.sample.model.SampleEntity
import com.ethanette.framework.room.dao.BaseDao
import kotlinx.coroutines.flow.Flow

/**
 * # dao
 * Package with dao implementations for each object.
 *
 * Naming convention: object name + EntityDao suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
@Dao
interface SampleEntityDao : BaseDao<SampleEntity> {

    @Query("SELECT * FROM ${SampleEntity.TABLE_NAME}")
    fun observeSampleList(): Flow<List<SampleEntity>>

    @Query("SELECT * FROM ${SampleEntity.TABLE_NAME} WHERE id = :id")
    fun observeSampleById(id: Int): Flow<SampleEntity?>

    @Query("DELETE FROM ${SampleEntity.TABLE_NAME} WHERE id = :id")
    suspend fun deleteSampleById(id: Int)

    @Query("DELETE FROM ${SampleEntity.TABLE_NAME}")
    suspend fun deleteSampleList()
}