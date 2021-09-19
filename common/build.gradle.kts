import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlinx-serialization")
}

android {
    compileSdk = Android.sdkVersion
    defaultConfig {
        minSdk = Android.minSdkVersion
        targetSdk = Android.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            java.srcDirs("src/androidMain/kotlin")
            res.srcDirs("src/androidMain/res")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType(KotlinCompile::class.java).all {
        kotlinOptions {
            jvmTarget = "11"
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
            }
        }
    }
}

dependencies {
    coreLibraryDesugaring(Libs.Desugar.desugar_libs)
}

kotlin {
    android()
    ios()

    version = "1.0"
    cocoapods {
        ios.deploymentTarget = "14"
        summary = "Common Library"
        homepage = "https://quibbly.com"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libs.Kotlin.Coroutines.core)
                api(Libs.Kotlin.Ktor.core)
                implementation(Libs.Kotlin.Ktor.json)
                api(Libs.Kotlin.Ktor.serialization)
                implementation(Libs.Kotlin.Ktor.logging)

                implementation(Libs.Koin.core)
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                // Ktor
                implementation(Libs.Kotlin.Coroutines.android)
                implementation(Libs.Kotlin.Ktor.android_core)
                implementation(Libs.Kotlin.Ktor.logback)
            }
        }
        val androidTest by getting {
            dependencies {

            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Libs.Kotlin.Ktor.ios_core)
                implementation(Libs.Kotlin.Ktor.native_logging)
            }
        }
        val iosTest by getting
    }
}