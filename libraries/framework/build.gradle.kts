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
}

dependencies {
    implementation(libs.androidx.paging.pagingRuntime)
    // Test
    testImplementation(libs.junit.junit)
}