package com.ethanette.data.remote.sample.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * # android-template
 * Package with pojo classes that represents request structures and will be parsed with moshi.
 *
 * Naming convention: object name + Request/Response suffix
 *
 * @author hsjun85
 * @since 2022-05-18
 */

@JsonClass(generateAdapter = true)
data class SampleResponse(
    @Json(name = "results") val results: List<SampleInfo>?
)