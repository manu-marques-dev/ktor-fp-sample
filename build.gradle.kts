@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    application
    alias(libs.plugins.kotlin) //apply false
    alias(libs.plugins.ktor) //apply false
    alias(libs.plugins.ksp) //apply false
    alias(libs.plugins.serialization) //apply false
}


group = "com.example"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":contexts:shared"))
    implementation(libs.bundles.ktor.module)
    implementation(libs.bundles.ktor.app)
    testImplementation(libs.bundles.tests)
    //ksp("libs.libraries.ksp-plugin")
}





