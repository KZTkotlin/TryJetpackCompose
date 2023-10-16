// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.detekt)
}
detekt {
    source.setFrom(file(projectDir))
    config.setFrom(files("config/detekt/detekt.yml"))
    autoCorrect = true
    buildUponDefaultConfig = true
    parallel = true
}

dependencies {
    detektPlugins(libs.detekt.formatting)
}
