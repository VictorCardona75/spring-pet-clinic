rootProject.name = "spring-pet-clinic"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }

    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenCentral()
    }
}

include("services:domain")
include("services:app")