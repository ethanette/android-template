package com.ethanette.domain.repository

import com.ethanette.domain.model.Data
import kotlinx.coroutines.flow.Flow

/**
 * # android-template
 * # data repository
 * @author hsjun85
 * @since 2022-05-17
 */
interface DataRepository {

    fun deleteData()

    fun saveDataList(dataList: List<Data>)

    fun getDataList(): Flow<List<Data>>
}