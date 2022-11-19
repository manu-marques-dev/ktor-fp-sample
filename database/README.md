

# Database module

Module description to be completed

## Migrations
1. Test 1
2. Test 2

## Generate Jooq Code
1. Test 1
2. Test 2

## Libraries
- [jOOQ](https://www.jooq.org/)
- [Hikari Connection Pool](https://github.com/brettwooldridge/HikariCP)
- [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/)

## Gradle plugins
- [Gradle Docker Compose Plugin](https://github.com/avast/gradle-docker-compose-plugin)
  used to run a Postgres database instance
- [Flyway Gradle Plugin](https://flywaydb.org/documentation/usage/gradle/)
  used to run the migrations against the database to initialize the schemas
- [Gradle Jooq Plugin](https://github.com/etiennestuder/gradle-jooq-plugin)
  used to run the jOOQ code generator aganins the initialized database
