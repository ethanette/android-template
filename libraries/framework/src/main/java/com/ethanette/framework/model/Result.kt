package com.ethanette.framework.model

/**
 * # Result
 * A generic class that holds a value with its loading status.
 * @param <T>
 * @author ethan
 * @since 2021-11-04
 */
sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}
