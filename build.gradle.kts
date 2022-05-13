// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            setUrl("https://maven.pkg.github.com/ethanette/android-gradle-plugin")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_ACCESS_TOKEN")
            }
        }
    }
    dependencies {
        classpath(libs.ethanette.gradle)
        classpath(libs.android.tools.build.gradle)
        classpath(libs.jetbrains.kotlin.kotlinGradle)
        classpath(libs.jetbrains.kotlin.kotlinSerialization)
        classpath(libs.google.dagger.hiltAndroidGradle)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}