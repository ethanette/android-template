package com.ethanette.data.remote.sample

import com.ethanette.data.remote.sample.mapper.SampleInfoMapper
import com.ethanette.data.remote.sample.service.SampleService
import com.ethanette.data.sample.model.Sample
import com.ethanette.data.sample.source.SampleRemoteDataSource
import com.ethanette.framework.mapper.mapFrom
import com.ethanette.framework.model.Result
import com.ethanette.framework.network.fetchResponse
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

    override suspend fun getSampleList(): Result<List<Sample>> =
        fetchResponse(
            request = {
                service.getSampleList()
            },
            mapper = {
                it.results?.mapFrom(mapper) ?: emptyList()
            }
        )

    override suspend fun getSample(id: Int): Result<Sample> =
        fetchResponse(
            request = {
                service.getSample(id)
            },
            mapper = {
                mapper.mapFrom(it)
            }
        )

}