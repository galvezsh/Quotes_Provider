plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.galvezsh.quotes_provider"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.galvezsh.mvvm_1"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

// This is necessary to resolve the app compilation error. KAPT is not 100% supported for
// Kotlin 2.0.x, so the solutions are either to use Kotlin 1.9.x or to use Kotlin 2.0.x with this
// extension.
//
// Google recommends replacing KAPT with KSP, but it is not yet finalized, so until it
// is developed, this is the best solution.
hilt {
    enableAggregatingTask = false
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // ViewModel Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Extended icons for buttons
    implementation(libs.androidx.material.icons.extended)

    // Retrofit and Json-converter
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Dagger hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
}