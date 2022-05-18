package com.ethanette.data.sample.mapper

import com.ethanette.data.sample.model.Sample
import com.ethanette.domain.model.SampleModel
import com.ethanette.framework.mapper.Mapper
import javax.inject.Inject

/**
 * # mapper
 * Package with mappers to map from data models to domain layer models
 *
 * Naming convention: object name + Mapper suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
class SampleMapper @Inject constructor(
) : Mapper<Sample, SampleModel>() {

    override fun mapTo(obj: SampleModel): Sample =
        Sample(
            id = obj.id,
            name = obj.name
        )

    override fun mapFrom(obj: Sample): SampleModel =
        SampleModel(
            id = obj.id,
            name = obj.name
        )

}