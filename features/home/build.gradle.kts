@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.ethanette.androidLib.get().pluginId)
    id(libs.plugins.ethanette.compose.get().pluginId)
    id(libs.plugins.ethanette.hilt.get().pluginId)
}

android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":libraries:framework"))
    implementation(project(":domain"))
    // Test
    testImplementation(libs.junit.junit)
}