package com.ethanette.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * # SampleApp
 * # sample application
 *
 * @author hsjun85
 * @since 2022/05/26
 */
@HiltAndroidApp
class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}