package com.ethanette.data.remote.sample.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * # service
 * Package with retrofit services interfaces.
 *
 * @author hsjun85
 * @since 2022-05-18
 */

@JsonClass(generateAdapter = true)
data class SampleInfo(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?
)
