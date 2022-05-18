package com.ethanette.data.remote.sample.service

import com.ethanette.data.remote.sample.model.SampleInfo
import com.ethanette.data.remote.sample.model.SampleResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * # service
 * Package with retrofit services interfaces.
 *
 * Naming convention: feature name + Service suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
interface SampleService {

    @GET(SAMPLE)
    suspend fun getSampleList(): SampleResponse

    @GET("$SAMPLE/{id}")
    suspend fun getSample(
        @Path("id") id: Int
    ): SampleInfo

    companion object {
        const val SAMPLE = "sample"
    }

}