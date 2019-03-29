pluginManagement {
    repositories {
        maven("https://kotlin.bintray.com/kotlin-eap")
    }
}

rootProject.name = "kotlin-stdlib-multiplatform"

include("usage-demo")

enableFeaturePreview("GRADLE_METADATA")