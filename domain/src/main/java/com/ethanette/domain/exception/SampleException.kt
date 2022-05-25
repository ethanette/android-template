package com.ethanette.domain.exception

/**
 * # exception
 * Package with bussiness logic exceptions. Those exceptions could be thrown from domain,
 * data or sources levels and should be handled in feature level.
 *
 * Naming convention: case name + Exception suffix
 *
 * @author hsjun85
 * @since 2022-05-25
 */
class SampleException(
    message: String,
) : Exception(message)