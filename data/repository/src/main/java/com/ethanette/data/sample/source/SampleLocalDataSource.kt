package com.ethanette.data.sample.source

import com.ethanette.data.sample.model.Sample
import kotlinx.coroutines.flow.Flow

/**
 * # source
 * Package with source interfaces.
 *
 * Naming convention: feature name + source type + DataSource suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
interface SampleLocalDataSource {

    suspend fun insertSample(sample: Sample)

    fun observeSampleList(): Flow<List<Sample>>

    fun observeSample(id: Int): Flow<Sample?>

    suspend fun updateSample(sample: Sample)

    suspend fun deleteSample(id: Int)

}