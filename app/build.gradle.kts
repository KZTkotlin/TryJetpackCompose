plugins {
    id("com.android.application")
    kotlin("kapt")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.tryjetpackcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tryjetpackcompose"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":api"))
    implementation(project(":domain"))
    implementation(project(":model"))
    implementation(project(":repository"))
    implementation(project(":UI"))

    implementation(libs.bundles.androidx.base)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.splash)

    /** Compose */
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.androidx.compose)

    /** HTTP Connection */
    implementation(libs.bundles.http)

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

//    implementation("androidx.core:core-ktx:1.10.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//    implementation("androidx.activity:activity-compose:1.7.0")
//    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
