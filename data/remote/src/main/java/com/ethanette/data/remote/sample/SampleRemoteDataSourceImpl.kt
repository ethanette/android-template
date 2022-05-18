package com.ethanette.data.remote.sample

import com.ethanette.data.remote.sample.mapper.SampleInfoMapper
import com.ethanette.data.remote.sample.service.SampleService
import com.ethanette.data.sample.model.Sample
import com.ethanette.data.sample.source.SampleRemoteDataSource
import com.ethanette.framework.mapper.mapFrom
import javax.inject.Inject

/**
 * # RemoteDataSource
 * Remote data source implementation connects remote layer with data layer.
 *
 * Naming convention: feature name + RemoteDataSourceImpl suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
class SampleRemoteDataSourceImpl @Inject constructor(
    private val service: SampleService,
    private val mapper: SampleInfoMapper
) : SampleRemoteDataSource {

    override suspend fun getSampleList(): List<Sample> =
        service.getSampleList().results?.mapFrom(mapper) ?: emptyList()

    override suspend fun getSample(id: Int): Sample =
        service.getSample(id).let {
            mapper.mapFrom(it)
        }

}