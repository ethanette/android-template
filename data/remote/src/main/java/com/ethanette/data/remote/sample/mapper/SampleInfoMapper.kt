package com.ethanette.data.remote.sample.mapper

import com.ethanette.data.remote.sample.model.SampleInfo
import com.ethanette.data.sample.model.Sample
import com.ethanette.framework.mapper.Mapper
import javax.inject.Inject

/**
 * # model
 * Package with pojo classes that represents request structures and will be parsed with moshi.
 *
 * Naming convention: object name + Mapper suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */
class SampleInfoMapper @Inject constructor(
) : Mapper<SampleInfo, Sample>() {

    override fun mapTo(obj: Sample): SampleInfo =
        SampleInfo(
            id = obj.id,
            name = obj.name
        )

    override fun mapFrom(obj: SampleInfo): Sample =
        Sample(
            id = obj.id ?: 0,
            name = obj.name ?: ""
        )

}