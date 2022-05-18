package com.ethanette.data.sample.source

import com.ethanette.data.sample.model.Sample

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

    suspend fun getSampleList(): List<Sample>

    suspend fun getSample(id: Int): Sample?

}