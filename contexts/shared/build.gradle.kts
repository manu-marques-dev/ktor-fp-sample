@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `java-library`
    alias(libs.plugins.kotlin)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    api(libs.bundles.ktor.module)
    implementation(libs.bundles.ktor.app)
    testImplementation(libs.bundles.tests)
}
