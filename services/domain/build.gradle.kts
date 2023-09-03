plugins {
    id("conventions.kotlin-library")
    alias(libs.plugins.dokka)
}

/*
 * Dokka Configuration
 */
tasks.dokkaHtmlPartial {
    outputDirectory.set(layout.buildDirectory.dir("docs/partial"))
}