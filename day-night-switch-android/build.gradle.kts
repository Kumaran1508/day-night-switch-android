plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.teknophase.daynightswitch"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles("consumer-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    buildFeatures {
        compose = true
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
                groupId = "com.github.Kumaran1508"
                artifactId = "day-night-switch-android"
                version = "1.0.0"

                pom {
                    name.set("Day-Night Switch")
                    description.set("An Android library for day-night switches.")
                    url.set("https://github.com/Kumaran1508/day-night-switch-android")

                    licenses {
                        license {
                            name.set("Apache License 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0")
                        }
                    }

                    developers {
                        developer {
                            id.set("teknophase")
                            name.set("Kumaran")
                            email.set("kumarans1508@gamil.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:git://github.com/Kumaran1508/day-night-switch-android.git")
                        developerConnection.set("scm:git:ssh://github.com/Kumaran1508/day-night-switch-android.git")
                        url.set("https://github.com/Kumaran1508/day-night-switch-android")
                    }
                }
            }
        }
    }
}

dependencies {
    implementation("androidx.compose.ui:ui:1.6.7")
    implementation("androidx.compose.material3:material3:1.2.1")

    implementation("androidx.compose.ui:ui-tooling")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
    }
}