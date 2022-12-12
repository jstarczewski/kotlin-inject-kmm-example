pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        id("com.google.devtools.ksp").version("1.7.10-1.0.6")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KotlinInjectKmm"
include(":androidApp")
include(":shared")