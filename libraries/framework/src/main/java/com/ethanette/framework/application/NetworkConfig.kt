package com.ethanette.framework.application

/**
 * # android-template
 * # network config
 * @author hsjun85
 * @since 2022-05-18
 */
abstract class NetworkConfig {

    abstract fun baseUrl(): String

    abstract fun timeOut(): Long

    open fun isDebug() = false

}