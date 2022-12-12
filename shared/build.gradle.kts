plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("me.tatarka.inject:kotlin-inject-runtime:0.5.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

kotlin.sourceSets.commonMain {
    kotlin.srcDir("build/generated/ksp/")
}

dependencies {
    add("kspAndroid", "me.tatarka.inject:kotlin-inject-compiler-ksp:0.5.1")
    add("kspIosX64","me.tatarka.inject:kotlin-inject-compiler-ksp:0.5.1")
    add("kspIosArm64", "me.tatarka.inject:kotlin-inject-compiler-ksp:0.5.1")
    add("kspIosSimulatorArm64", "me.tatarka.inject:kotlin-inject-compiler-ksp:0.5.1")
}

android {
    namespace = "com.jstarczewski.kotlininjectkmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}