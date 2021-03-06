package com.ethanette.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ethanette.data.local.sample.dao.SampleEntityDao
import com.ethanette.data.local.sample.model.SampleEntity

/**
 * # android-template
 * # Package with database constants
 * @author hsjun85
 * @since 2022-05-18
 */
@Database(
    entities = [SampleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SampleDatabase : RoomDatabase() {

    abstract fun sampleEntityDao(): SampleEntityDao

}