@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.ethanette.androidApp.get().pluginId)
    id(libs.plugins.ethanette.hilt.get().pluginId)
    id(libs.plugins.ethanette.compose.get().pluginId)
}

android {
    defaultConfig {
        applicationId = "com.ethanette.app"
        versionName = "1.0.0"
        versionCode = 1
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":common:component"))
    implementation(project(":libraries:framework"))
    implementation(project(":data:local"))
    implementation(project(":data:remote"))
    implementation(project(":data:repository"))
    implementation(project(":domain"))
    implementation(project(":features:sample"))

    implementation(libs.androidx.core.coreKtx)
    implementation(libs.androidx.lifecycle.lifecycleRuntimeKtx)
    implementation(libs.androidx.activity.activityCompose)
}
