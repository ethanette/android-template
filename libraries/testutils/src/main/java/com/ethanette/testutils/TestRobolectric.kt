package com.ethanette.testutils

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * # android-template
 * # Test Robolectric
 * @author hsjun85
 * @since 2022/06/17
 */
@RunWith(RobolectricTestRunner::class)
@Config(
    manifest = "AndroidManifest.xml",
    application = TestRobolectric.ApplicationStub::class,
    sdk = [Build.VERSION_CODES.M]
)
open class TestRobolectric : MockkUnitTest() {

    protected val application: Application by lazy {
        ApplicationProvider.getApplicationContext<ApplicationStub>()
    }

    protected val context: Context by lazy {
        application
    }

    internal class ApplicationStub : Application()

}