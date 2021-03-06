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
    implementation(libs.androidx.paging.pagingRuntime)

    implementation(libs.androidx.room.roomKtx)

    implementation(libs.squareup.moshi.moshiKotlin)
    implementation(libs.squareup.moshi.moshiKotlinCodegen)
    implementation(libs.squareup.retrofit2.retrofit)
    implementation(libs.squareup.retrofit2.converterMoshi)
    implementation(libs.squareup.okhttp3.okhttp)
    implementation(libs.squareup.okhttp3.loggingInterceptor)
    implementation(libs.squareup.okhttp3.mockwebserver)
    debugImplementation(libs.chuckerteam.chucker.library)
    releaseImplementation(libs.chuckerteam.chucker.libraryNoOp)

    implementation(libs.jakewharton.timber.timber)

    // Test
    testImplementation("io.mockk:mockk:1.12.4")
    testImplementation(libs.junit.junit)
}