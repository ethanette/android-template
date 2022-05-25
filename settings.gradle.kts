enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
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

    versionCatalogs {
        create("libs") {
            from("com.github.ethanette:version-catalog:0.1.9")
        }
    }
}
rootProject.name = "android-template"
include(
    ":common:theme",
    ":libraries:framework",
    "data:local",
    "data:remote",
    "data:repository",
    "domain",
    "feature:home",
    "app"
)