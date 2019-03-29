import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetPreset
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation

plugins {
    kotlin("multiplatform").version("1.3.30-eap-125")
    `maven-publish`
}

group = "com.github.h0tk3y"
version = "1.3.30-eap-125"

repositories {
    maven("https://kotlin.bintray.com/kotlin-eap")
    jcenter()
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                api(kotlin("stdlib-common"))
            }
        }
    }

    jvm() {
        compilations["main"].defaultSourceSet {
            dependencies {
                api(kotlin("stdlib"))
            }
        }
    }

    js() {
        compilations["main"].defaultSourceSet {
            dependencies {
                api(kotlin("stdlib-js"))
            }
        }
    }

    configure(listOf(jvm(), js(), metadata())) {
        val main: KotlinCompilation<*> by compilations
        main.kotlinOptions.freeCompilerArgs += "-Xallow-kotlin-package"
    }

    presets.withType<KotlinNativeTargetPreset>().forEach { nativePreset ->
        targetFromPreset(nativePreset)
    }
}

publishing {
    repositories {
        maven("$buildDir/repo")
    }
}