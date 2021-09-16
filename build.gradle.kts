buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Libs.kotlin_version}")
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}