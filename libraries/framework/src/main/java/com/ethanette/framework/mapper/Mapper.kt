package com.ethanette.framework.mapper

/**
 * # Mapper
 *
 * @author ethan
 * @since 2021-11-04
 */
abstract class Mapper<L, R> {

    /**
     * Map a [R] instance to a [L] instance
     */
    abstract fun mapTo(obj: R): L

    /**
     * Map a [L] instance to a [R] instance
     */
    abstract fun mapFrom(obj: L): R

}

fun <L, R> List<L>.mapFrom(mapper: Mapper<L, R>): List<R> =
    map {
        mapper.mapFrom(it)
    }

fun <L, R> List<R>.mapTo(mapper: Mapper<L, R>): List<L> =
    map {
        mapper.mapTo(it)
    }