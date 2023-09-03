package conventions

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

val libs = the<LibrariesForLibs>()

plugins {
    id("conventions.kotlin-common")
    id("org.springframework.boot")
    id("com.google.cloud.tools.jib")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    implementation(libs.spring.boot.starter.actuator)

    annotationProcessor(platform(libs.spring.boot.bom))
    annotationProcessor(libs.spring.boot.configuration.processor)

    runtimeOnly(platform(libs.spring.boot.bom))
    runtimeOnly(libs.micrometer.registry.prometheus)
}

/*
 * Configure Jib, and have it automatically produce an image during the assembly phase.
 */
jib {
    from {
        image = "azul/zulu-openjdk:20-latest"
    }
    to {
        image = "VictorCardona/spring-pet-clinic"
    }
}

tasks.assemble.configure {
    dependsOn(tasks.jibDockerBuild)
}