plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)

    // Hilt
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.mahshad.network"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Hilt Core
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // Hilt Navigation
    implementation(libs.androidx.hilt.navigation.compose)

    // Retrofit Core
    implementation(libs.retrofit)

    // Retrofit Gson Converter (to convert JSON to Kotlin objects)
    implementation(libs.converter.gson)

    // OkHttp Logging Interceptor (helps you see the network traffic in Logcat)
    implementation(libs.logging.interceptor)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}