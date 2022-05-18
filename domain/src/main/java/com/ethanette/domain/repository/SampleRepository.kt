package com.ethanette.domain.repository

import com.ethanette.domain.model.SampleModel
import kotlinx.coroutines.flow.Flow

/**
 * # android-template
 * # SampleRepository
 * A sample repository with CRUD operations on a model.
 * @author hsjun85
 * @since 2022-05-17
 */
interface SampleRepository {

    fun observeSample(id: Int): Flow<SampleModel?>

    fun observeSampleList(): Flow<List<SampleModel>>

    suspend fun updateSample(sample: SampleModel)

    suspend fun deleteSample(id: Int)

}