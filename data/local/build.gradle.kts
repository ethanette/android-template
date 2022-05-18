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

    implementation("androidx.room:room-ktx:2.4.2")
    // TODO [ethan] ksp 변경 작업
    kapt("androidx.room:room-compiler:2.4.2")

    // Test
    testImplementation(libs.junit.junit)
}