plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.aula09tarefa"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.aula09tarefa"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
}