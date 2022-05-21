package com.ethanette.data.sample.repository

import com.ethanette.data.sample.mapper.SampleMapper
import com.ethanette.data.sample.source.SampleLocalDataSource
import com.ethanette.data.sample.source.SampleRemoteDataSource
import com.ethanette.domain.model.SampleModel
import com.ethanette.domain.repository.SampleRepository
import com.ethanette.framework.mapper.mapFrom
import com.ethanette.framework.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * # repository
 * Package with repositories interfaces implementations.Repository contains logic that manages data between sources.
 *
 * Naming convention: feature name + RepositoryImpl suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
class SampleRepositoryImpl @Inject constructor(
    private val local: SampleLocalDataSource,
    private val remote: SampleRemoteDataSource,
    private val mapper: SampleMapper
) : SampleRepository {

    override fun observeSampleList(): Flow<List<SampleModel>> =
        local.observeSampleList().map {
            it.mapFrom(mapper)
        }

    override suspend fun refreshSampleList() {
        val result = remote.getSampleList()
        if (result is Result.Success) {
            local.deleteSampleList()
            local.insertSampleList(result.data)
        }
    }

    override fun observeSample(id: Int): Flow<SampleModel?> =
        local.observeSample(id).map {
            it?.let { mapper.mapFrom(it) }
        }

    override suspend fun refreshSample(id: Int) {
        val result = remote.getSample(id)
        if (result is Result.Success) {
            local.updateSample(result.data)
        }
    }

    override suspend fun updateSample(sample: SampleModel) {
        local.updateSample(mapper.mapTo(sample))
    }

    override suspend fun deleteSample(id: Int) {
        local.deleteSample(id)
    }

}