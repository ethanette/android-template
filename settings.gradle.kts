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
            from("com.github.ethanette:version-catalog:0.2.1")
        }
    }
}
rootProject.name = "android-template"
include(
    ":common:theme",
    ":common:component",
    ":libraries:framework",
    ":libraries:testutils",
    "data:local",
    "data:remote",
    "data:repository",
    "domain",
    "features:sample",
    "app"
)