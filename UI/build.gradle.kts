@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    kotlin("kapt")
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.ui"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    implementation(project(":model"))
    implementation(project(":domain"))

    implementation(libs.bundles.androidx.base)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.splash)

    /** Compose */
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.androidx.compose)

    /** Coroutines */
    implementation(libs.coroutines)

    /** DI */
    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    /** Lottie */
    implementation(libs.compose.lottie)

    /** Timber */
    implementation(libs.timber)

    /** Debug */
    debugImplementation(libs.bundles.debug.compose)

    /** test */
    testImplementation(libs.bundles.test.all)

    /** androidTest */
    androidTestImplementation(libs.bundles.androidx.test.all)
    androidTestImplementation(platform(libs.compose.bom))

    implementation(libs.material)
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}
