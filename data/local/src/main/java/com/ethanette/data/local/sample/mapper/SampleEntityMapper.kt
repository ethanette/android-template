package com.ethanette.data.local.sample.mapper

import com.ethanette.data.local.sample.model.SampleEntity
import com.ethanette.data.sample.model.Sample
import com.ethanette.framework.mapper.Mapper
import javax.inject.Inject

/**
 * # mapper
 * Package with mappers to map from data layer models to local models
 *
 * Naming convention: object name + EntityMapper suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
class SampleEntityMapper @Inject constructor(
) : Mapper<SampleEntity, Sample>() {

    override fun mapTo(obj: Sample): SampleEntity =
        SampleEntity(
            id = obj.id,
            name = obj.name
        )

    override fun mapFrom(obj: SampleEntity): Sample =
        Sample(
            id = obj.id,
            name = obj.name
        )

}