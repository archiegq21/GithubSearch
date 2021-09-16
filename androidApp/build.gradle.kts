plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = Android.sdkVersion
    defaultConfig {
        applicationId = "com.quibbly.githubsearch"
        minSdk = Android.minSdkVersion
        targetSdk = Android.targetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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

    kotlinOptions {
        jvmTarget = "11"
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
        }

    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Jetpack.Compose.compose_version
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    coreLibraryDesugaring(Libs.Desugar.desugar_libs)

    // Jetpack
    implementation(Libs.Jetpack.core)
    implementation(Libs.Jetpack.activity)
    implementation(Libs.Jetpack.fragment)
    implementation(Libs.Jetpack.material)

    // Compose
    implementation(Libs.Jetpack.Compose.activity)
    implementation(Libs.Jetpack.Compose.ui)
    implementation(Libs.Jetpack.Compose.ui_util)
    implementation(Libs.Jetpack.Compose.animation)
    implementation(Libs.Jetpack.Compose.material)
    implementation(Libs.Jetpack.Compose.icon)
    implementation(Libs.Jetpack.Compose.runtime)
    implementation(Libs.Jetpack.Compose.livedata)
    implementation(Libs.Jetpack.Compose.navigation)
    implementation(Libs.Jetpack.Compose.lifecycler_compose)
    debugImplementation(Libs.Jetpack.Compose.ui_tooling)
    debugImplementation(Libs.Kotlin.reflect)

    // Compose Coil
    implementation(Libs.Jetpack.Compose.coil)
    implementation(Libs.Jetpack.Compose.insets)
    implementation(Libs.Jetpack.Compose.swipe_refresh)

    // Compose Testing
    androidTestImplementation(Libs.Jetpack.Compose.ui_test)
    androidTestImplementation(Libs.Jetpack.Compose.ui_test_junit)

    // Koin
    implementation(Libs.Koin.android)

    // Coroutines
    implementation(Libs.Kotlin.Coroutines.android)

    // Ktor
    implementation(Libs.Kotlin.Ktor.android_core)
    implementation(Libs.Kotlin.Ktor.logback)
    implementation(Libs.Kotlin.Ktor.core)
    implementation(Libs.Kotlin.Ktor.json)
    implementation(Libs.Kotlin.Ktor.serialization)
    implementation(Libs.Kotlin.Ktor.logging)

    // Espresso
    androidTestImplementation(Libs.Espresso.core)

    // Testing
    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.junit_ext)
}