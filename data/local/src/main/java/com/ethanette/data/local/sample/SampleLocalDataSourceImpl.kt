package com.ethanette.data.local.sample

import androidx.annotation.VisibleForTesting
import com.ethanette.data.local.sample.dao.SampleEntityDao
import com.ethanette.data.local.sample.mapper.SampleEntityMapper
import com.ethanette.data.sample.model.Sample
import com.ethanette.data.sample.source.SampleLocalDataSource
import com.ethanette.framework.mapper.mapFrom
import com.ethanette.framework.mapper.mapTo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * # LocalDataSource
 * # Local data source implementation connects local layer with data layer.
 *
 *  Naming convention: feature name + CacheDataSourceImpl suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
class SampleLocalDataSourceImpl @Inject constructor(
    @get:VisibleForTesting
    internal val dao: SampleEntityDao,
    @get:VisibleForTesting
    internal val mapper: SampleEntityMapper
) : SampleLocalDataSource {

    override suspend fun insertSampleList(sample: List<Sample>) {
        dao.insert(sample.mapTo(mapper))
    }

    override fun observeSampleList(): Flow<List<Sample>> =
        dao.observeSampleList().map {
            it.mapFrom(mapper)
        }

    override suspend fun insertSample(sample: Sample) =
        dao.insert(mapper.mapTo(sample))

    override fun observeSample(id: Int): Flow<Sample?> =
        dao.observeSampleById(id).map { it ->
            it?.let { mapper.mapFrom(it) }
        }

    override suspend fun updateSample(sample: Sample) {
        dao.update(mapper.mapTo(sample))
    }

    override suspend fun deleteSample(id: Int) {
        dao.deleteSampleById(id)
    }

    override suspend fun deleteSampleList() {
        dao.deleteSampleList()
    }

}