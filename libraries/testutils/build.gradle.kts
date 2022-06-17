@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.ethanette.androidLib.get().pluginId)
}

android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        freeCompilerArgs = listOf(
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        )
    }
}

dependencies {
    api(libs.junit.junit)
    api(libs.androidx.test.ext.junit)
    api(libs.androidx.test.core)
    api(libs.androidx.test.coreKtx)
    api(libs.jetbrains.kotlinx.kotlinxCoroutinesTest)
    api("io.mockk:mockk:1.12.3")
    api("org.robolectric:robolectric:4.7.3")
}