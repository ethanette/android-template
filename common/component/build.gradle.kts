@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.ethanette.androidLib.get().pluginId)
    id(libs.plugins.ethanette.compose.get().pluginId)
}

android {
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        // Enable experimental compose APIs
        freeCompilerArgs = freeCompilerArgs.plus(
            listOf(
                "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi",
                "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi"
            )
        )
    }
}

dependencies {
    api(project(":common:theme"))
    // DataPicker
    implementation(libs.androidx.paging.pagingCompose)
    coreLibraryDesugaring(libs.android.tools.desugarJdkLibs)

    // ScrollableTabRow
    implementation(libs.androidx.compose.ui.uiUtil)
    implementation(libs.google.accompanist.accompanistPager)
    implementation(libs.google.accompanist.accompanistPagerIndicators)

    // Test
    testImplementation(libs.junit.junit)
}