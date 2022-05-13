@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.ethanette.androidApp.get().pluginId)
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
    implementation(libs.androidx.core.coreKtx)
    implementation(libs.androidx.lifecycle.lifecycleRuntimeKtx)
    implementation(libs.androidx.activity.activityCompose)
}
