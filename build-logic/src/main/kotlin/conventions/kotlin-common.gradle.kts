package conventions

import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

val libs = the<LibrariesForLibs>()

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("io.gitlab.arturbosch.detekt")
}

kotlin {
    // Make sure the project compiles on JDK 20.
    jvmToolchain(20)
    compilerOptions {
        apiVersion.set(KotlinVersion.KOTLIN_2_0)
        languageVersion.set(KotlinVersion.KOTLIN_2_0)
    }
}


detekt {
    buildUponDefaultConfig = true
    config.setFrom("$rootDir/detekt.yaml")
}

testing {
    suites {
        configureEach {
            if (this is JvmTestSuite) {
                useJUnitJupiter()
                dependencies {
                    implementation(project.dependencies.platform(libs.kotest.bom))
                    implementation.bundle(libs.bundles.kotest)
                    implementation.bundle(libs.bundles.kotest.assertions)
                    implementation(libs.kotest.property)
                    implementation(libs.mockk)
                    implementation(libs.kotlin.reflect)
                }
                targets {
                    all {
                        testTask.configure {
                            testLogging {
                                events("skipped", "failed")
                            }
                        }
                    }
                }
            }
        }
    }
}