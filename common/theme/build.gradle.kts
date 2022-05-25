@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.ethanette.androidLib.get().pluginId)
    id(libs.plugins.ethanette.compose.get().pluginId)
}

android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // Test
    testImplementation(libs.junit.junit)
}