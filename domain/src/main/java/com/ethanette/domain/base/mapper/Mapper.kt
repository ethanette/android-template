package com.ethanette.domain.base.mapper

/**
 * # Mapper
 *
 * @author ethan
 * @since 2021-11-04
 */
interface Mapper<L, R> {

    fun toEntity(obj: R): L

    fun toModel(obj: L): R

}