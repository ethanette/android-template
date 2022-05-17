package com.ethanette.framework.mapper

/**
 * # Mapper
 *
 * @author ethan
 * @since 2021-11-04
 */
interface Mapper<in L, R> {

    fun map(obj: L): R

}