@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.ethanette.androidLib.get().pluginId)
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
    implementation(project(":data:repository"))

    implementation(libs.androidx.room.roomKtx)
    // TODO [ethan] ksp 변경 작업
    kapt(libs.androidx.room.roomCompiler)

    // Test
    testImplementation(libs.junit.junit)
}