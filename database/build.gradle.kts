import org.jooq.meta.jaxb.Logging

val jooqVersion: String by project

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `java-library`
    alias(libs.plugins.kotlin)
    alias(libs.plugins.flyway)
    alias(libs.plugins.docker.compose)
    alias(libs.plugins.jooq.plugin)
}

repositories {
    mavenCentral()
}

dependencies {
    api(libs.bundles.database)
    jooqGenerator(libs.postgresql.driver)
}

dockerCompose {
    useComposeFiles.set(listOf("docker-compose-generate-jooq.yml"))
}

flyway {
    url = "jdbc:postgresql://localhost:5433/sample"
    user = "testuser"
    password = "testpass"
}

jooq {
    version.set(jooqVersion)

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(true)
            jooqConfiguration.apply {
                logging = Logging.WARN
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://localhost:5433/sample"
                    user = "testuser"
                    password = "testpass"
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = true
                        isPojosEqualsAndHashCode = true
                        isFluentSetters = true
                        isRelations = true
                        isDaos = true
                    }
                    target.apply {
                        packageName = "com.example.database.generated"
                        directory = "src/main/kotlin"
                    }
                }
            }
        }
    }
}

tasks.getByName("flywayMigrate") {
    dependsOn(tasks.getByName("composeUp"))
}

tasks.getByName("generateJooq") {
    inputs.dir("${projectDir}/src/main/resources/db/migration")
    outputs.cacheIf { true }
    dependsOn(tasks.getByName("flywayMigrate"))
    finalizedBy(tasks.getByName("composeDownForced"))
}
