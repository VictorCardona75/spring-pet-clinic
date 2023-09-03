plugins {
    id("conventions.kotlin-spring-application")
    alias(libs.plugins.dokka)
}

dependencies {
    implementation(libs.spring.boot.starter.webflux)

    runtimeOnly(libs.bundles.reactive.postgresql)
}

/*
 * Dokka Configuration
 */
tasks.dokkaHtmlPartial {
    outputDirectory.set(layout.buildDirectory.dir("docs/partial"))
}