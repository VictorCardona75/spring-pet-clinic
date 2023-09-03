package conventions

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

val libs = the<LibrariesForLibs>()

plugins {
    id("conventions.kotlin-common")
}

kotlin {
    explicitApi = ExplicitApiMode.Strict
}

dependencies {

}
