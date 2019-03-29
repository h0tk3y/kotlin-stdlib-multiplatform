import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetPreset
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation

plugins {
    kotlin("multiplatform")
}

group = "org.jetbrains.kotlin"
version = "1.3.30-eap-125"

repositories {
    maven("$projectDir/../build/repo")
    maven("https://kotlin.bintray.com/kotlin-eap")
    jcenter()
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(kotlin("stdlib-multiplatform"))
            }
        }
    }

    jvm()

    js()

    presets.withType<KotlinNativeTargetPreset>().forEach { nativePreset ->
        targetFromPreset(nativePreset)
    }
}