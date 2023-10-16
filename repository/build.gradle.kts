@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    kotlin("kapt")
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.repository"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":api"))
    implementation(project(":model"))

    /** HTTP Connection */
    implementation(libs.bundles.http)
    implementation(libs.retrofit.gson)

    /** DI */
    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    /** Timber */
    implementation(libs.timber)

    /** test */
    testImplementation(libs.bundles.test.all)

}
