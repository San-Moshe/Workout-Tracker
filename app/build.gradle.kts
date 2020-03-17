import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
    id("com.akaita.android.easylauncher")
}

androidExtensions {
    isExperimental = true
    features = setOf("views", "parcelize")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        targetSdkVersion(28)
        minSdkVersion(24)
        applicationId = "com.san"
        versionCode = 1
        versionName = "1.0"

        val scheme = "gank"

        buildConfigField("String", "SCHEME", "\"$scheme\"")

        manifestPlaceholders = mapOf(
            "APPLICATION_ID" to applicationId,
            "SCHEME" to scheme
        )
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":backend"))

    // Kotlin
    implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))

    // Androidx
    implementation("androidx.appcompat:appcompat:1.1.0-rc01")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0-beta01")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta2")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.0.0")

    // Fragment
    implementation("androidx.fragment:fragment-ktx:1.2.2")

    // Material
    implementation("com.google.android.material:material:1.1.0")

    //Room
    val room_version = "2.2.4"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version") // For Kotlin use kapt instead of annotationProcessor

    // Navigation
    val nav_version = "2.2.1"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // ReactiveX
    implementation("com.uber.autodispose:autodispose:1.3.0")
    implementation("com.uber.autodispose:autodispose-android:1.3.0")
    implementation("com.uber.autodispose:autodispose-android-archcomponents:1.3.0")

    // Dependency injection
    implementation("com.google.dagger:dagger:2.24")
    kapt("com.google.dagger:dagger-compiler:2.24")

    // Others
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("com.evernote:android-state:1.4.1")
    kapt("com.evernote:android-state-processor:1.4.1")

    // For debugging
    debugImplementation("com.facebook.flipper:flipper:0.23.2")
    debugImplementation("com.facebook.soloader:soloader:0.6.1")
    releaseImplementation("com.facebook.flipper:flipper-noop:0.23.2")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-core:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-attr:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-build-config:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-crash:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-disk:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-geiger-counter:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-measurement:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-phoenix:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-recorder:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-shared-preferences:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-timber:0.9.27")
    releaseImplementation("com.willowtreeapps.hyperion:hyperion-core-no-op:0.9.27")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    // Circular imageView
    implementation("de.hdodenhof:circleimageview:3.1.0")

}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
    kotlinOptions.jvmTarget = "1.8"
}
