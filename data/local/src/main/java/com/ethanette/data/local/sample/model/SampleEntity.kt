package com.ethanette.data.local.sample.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # model
 * Package with pojo classes that represents database entities.
 *
 * Naming convention: object name + Entity suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
@Entity(tableName = SampleEntity.TABLE_NAME)
data class SampleEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = COLUMN_ID) val id: Int,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
) {
    companion object {
        const val TABLE_NAME = "sample"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
    }
}
