object Libs {
    const val kotlin_version = "1.5.30"

    object Desugar {
        private const val version = "1.1.5"
        const val desugar_libs = "com.android.tools:desugar_jdk_libs:$version"
    }

    object Jetpack {
        private const val lifecycle_version = "2.3.0-rc01"

        private const val core_ktx_version = "1.5.0-beta03"
        const val core = "androidx.core:core-ktx:$core_ktx_version"

        private const val activity_version = "1.3.1"
        const val activity = "androidx.activity:activity-ktx:$activity_version"

        private const val fragment_ktx_version = "1.3.6"
        const val fragment = "androidx.fragment:fragment-ktx:$fragment_ktx_version"

        private const val material_version = "1.5.0-alpha02"
        const val material = "com.google.android.material:material:$material_version"

        object Compose {
            const val compose_version = "1.1.0-alpha03"
            private const val navigation_compose_version = "2.4.0-alpha08"
            private const val accompanist_version = "0.18.0"

            const val activity = "androidx.activity:activity-compose:$activity_version"
            const val ui = "androidx.compose.ui:ui:$compose_version"
            const val ui_tooling = "androidx.compose.ui:ui-tooling:$compose_version"
            const val ui_util = "androidx.compose.ui:ui-util:$compose_version"
            const val animation = "androidx.compose.animation:animation:$compose_version"
            const val material = "androidx.compose.material:material:$compose_version"
            const val icon = "androidx.compose.material:material-icons-extended:$compose_version"
            const val runtime = "androidx.compose.runtime:runtime:$compose_version"
            const val livedata = "androidx.compose.runtime:runtime-livedata:$compose_version"
            const val ui_test = "androidx.compose.ui:ui-test:$compose_version"
            const val ui_test_junit = "androidx.compose.ui:ui-test-junit4:$compose_version"
            const val navigation =
                "androidx.navigation:navigation-compose:$navigation_compose_version"
            const val lifecycler_compose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
            const val coil = "io.coil-kt:coil-compose:1.3.2"
            const val insets = "com.google.accompanist:accompanist-insets:$accompanist_version"
            const val swipe_refresh = "com.google.accompanist:accompanist-swiperefresh:$accompanist_version"
        }
    }

    object Kotlin {
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"

        object Coroutines {
            private const val coroutine_version = "1.5.1-native-mt"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutine_version}"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutine_version}"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${coroutine_version}"
        }

        object Ktor {
            private const val ktor_version = "1.6.2"
            private const val logback_version = "1.2.5"

            const val core = "io.ktor:ktor-client-core:$ktor_version"
            const val json = "io.ktor:ktor-client-json:$ktor_version"
            const val android_core = "io.ktor:ktor-client-okhttp:$ktor_version"
            const val ios_core = "io.ktor:ktor-client-ios:$ktor_version"
            const val serialization = "io.ktor:ktor-client-serialization:$ktor_version"
            const val auth = "io.ktor:ktor-client-auth:$ktor_version"
            const val logging = "io.ktor:ktor-client-logging:$ktor_version"
            const val native_logging = "io.ktor:ktor-client-logging-native:1.3.1"
            const val logback = "ch.qos.logback:logback-classic:$logback_version"
        }
    }

    object SqlDelight {
        const val version = "1.5.1"
        const val runtime = "com.squareup.sqldelight:runtime:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
        const val ios = "com.squareup.sqldelight:native-driver:$version"
        const val coroutines_ktx = "com.squareup.sqldelight:coroutines-extensions:$version"
    }

    object MultipaltformSettings {
        private const val version = "0.7.7"
        const val no_args = "com.russhwolf:multiplatform-settings-no-arg:$version"
    }

    object Maps {
        const val core = "com.google.android.libraries.maps:maps:3.1.0-beta"
        const val ktx = "com.google.maps.android:maps-v3-ktx:3.0.1"
    }

    object Koin {
        private const val version = "3.1.2"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }

    object Test {
        private const val junit_version = "4.13.2"
        private const val junit_ext_version = "1.1.2"

        const val junit = "junit:junit:$junit_version"
        const val junit_ext = "androidx.test.ext:junit:$junit_ext_version"
    }

    object Espresso {
        private const val espresso_core_version = "3.3.0"
        const val core = "androidx.test.espresso:espresso-core:$espresso_core_version"
    }
}