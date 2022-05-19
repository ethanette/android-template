package com.ethanette.data.sample.source

import com.ethanette.data.sample.model.Sample
import com.ethanette.framework.model.Result

/**
 * # source
 * Package with source interfaces.
 *
 * Naming convention: feature name + source type + DataSource suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
interface SampleRemoteDataSource {

    suspend fun getSampleList(): Result<List<Sample>>

    suspend fun getSample(id: Int): Result<Sample>

}