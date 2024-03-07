import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
    id("io.gitlab.arturbosch.detekt")
}

android {
    compileSdk = 34
    namespace = "com.kirozh.smartschool"

    defaultConfig {
        applicationId = "com.kirozh.smartschool"
        minSdk = 21
        targetSdk = 34
        versionCode = 10
        versionName = "0.1.0"
        multiDexEnabled = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
    }
}

allprojects {
    group = rootProject.libs.plugins.detekt.get().pluginId
    version = rootProject.libs.versions.detekt.get()
    apply(plugin = rootProject.libs.plugins.detekt.get().pluginId)

    detekt {
        toolVersion = rootProject.libs.versions.detekt.get()
        source.setFrom("src")
        config.setFrom("$rootDir/config/detekt.yml")
        buildUponDefaultConfig = true
        baseline = file("$rootDir/config/detekt-baseline.xml")
        basePath = projectDir.absolutePath
    }

    tasks.withType<Detekt>().configureEach {
        reports {
            html.required.set(true)
            xml.required.set(false)
            txt.required.set(true)
            sarif.required.set(false)
            md.required.set(false)
        }
    }

    tasks.withType<Detekt>().configureEach {
        jvmTarget = "1.8"
    }
    tasks.withType<DetektCreateBaselineTask>().configureEach {
        jvmTarget = "1.8"
    }
}

detekt {
    toolVersion = "1.23.0"
    config.setFrom(files("config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat.appcompat)
    implementation(libs.android.material.material)
    implementation(libs.androidx.constraintlayout.constraintlayout)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.espresso.core)
    implementation(libs.timber)
    implementation(libs.retrofit)

    // Compose
    implementation(libs.androidx.activity.activity.compose)
    implementation(libs.androidx.compose.ui.ui)
    implementation(libs.androidx.compose.material.material)
    implementation(libs.androidx.compose.ui.ui.tooling.preview)
    implementation(libs.androidx.compose.runtime.runtime)
    implementation(libs.androidx.compose.foundation.foundation)
    implementation(libs.androidx.compose.foundation.foundation.layout)
    implementation(libs.androidx.compose.material.material)
    implementation(libs.androidx.compose.runtime.runtime.livedata)
    implementation(libs.androidx.compose.ui.ui.tooling)
    implementation(libs.androidx.navigation.navigation.compose)
    implementation(libs.com.google.android.material.compose.theme.adapter)
    implementation(libs.accompanist.insets)

    // Room
    implementation(libs.androidx.room.room.runtime)
    implementation(libs.androidx.room.room.ktx)
    implementation(libs.com.android.support.multidex)
    ksp(libs.room.compiler)

    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.androidx.navigation)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.android)
    testImplementation(libs.io.insert.koin.koin.test.junit4)

    // Firebase
    implementation(project.dependencies.platform("com.google.firebase:firebase-bom:32.7.3"))
    implementation(libs.firebase.database)
}