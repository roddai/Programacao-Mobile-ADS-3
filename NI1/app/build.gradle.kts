plugins {
    id("com.android.application") version "8.7.1"
    id("org.jetbrains.kotlin.android")
}


android {
    namespace = "com.example.ni1"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.ni1"
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

}

dependencies {

    dependencies {
        implementation("androidx.core:core:1.12.0")
        implementation("androidx.core:core-ktx:1.12.0")

        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    }

}