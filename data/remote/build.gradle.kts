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

    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")
    implementation("com.serjltt.moshi:moshi-lazy-adapters:2.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.5")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.5")
    testImplementation("com.squareup.okhttp3:mockwebserver:5.0.0-alpha.5")
    debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")

    // Test
    testImplementation(libs.junit.junit)
}