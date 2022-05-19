package com.ethanette.framework.network

import com.ethanette.framework.model.Result
import retrofit2.Response

/**
 * # android-template
 * # Response helper
 * @author hsjun85
 * @since 2022/05/20
 */

suspend fun <T: Any, R> fetchResponse(request: suspend () -> Response<T>, mapper: suspend (T) -> R): Result<R> =
    try {
        val response = request()
        if (response.isSuccessful) {
            response.body()?.let { return Result.Success(mapper(it)) }
        }
        Result.Error(RuntimeException("${response.code()} ${response.message()}"))
    } catch (e: Exception) {
        Result.Error(e)
    }