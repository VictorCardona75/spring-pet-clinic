plugins {
    `kotlin-dsl`
}

dependencies {
    // https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.gradlePlugin.kotlin)
    implementation(libs.gradlePlugin.spring.boot)
    implementation(libs.gradlePlugin.detekt)
    implementation(libs.gradlePlugin.jib)
}
