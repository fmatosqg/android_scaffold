import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")

}

android {


    dataBinding.isEnabled = true

    compileSdkVersion(28)
    defaultConfig {
        applicationId = "net.amazingdomain.sample.myapplication"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    // extra flavors
    val dimensionApi = "api"
    flavorDimensions(dimensionApi)

    productFlavors {
        create("mock") {
            dimension = dimensionApi
            applicationIdSuffix = ".mock"
            buildConfigField("String", "SERVER_URL", "\"${Environments.serverUrl}\"")
        }
        create("cloud") {
            dimension = dimensionApi

            buildConfigField("String", "SERVER_URL", "\"${Environments.serverUrl}\"")
        }
    }
}

dependencies {


    //    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    /////////////////////////////////////////
    // language
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1")


    //////////////////////////////////////
    // google libs

    val supportLibraryVersion = "28.0.0"
    // support libs
    implementation("com.android.support:appcompat-v7:$supportLibraryVersion")
    implementation("com.android.support:cardview-v7:$supportLibraryVersion")
    implementation("com.android.support:support-v13:$supportLibraryVersion")
    implementation("com.android.support:design:$supportLibraryVersion")
    implementation("com.android.support:support-dynamic-animation:$supportLibraryVersion")

    // android x
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")


    // live data and data binding
    val lifecycleVersion = "2.0.0"
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycleVersion")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")
    kapt("com.android.databinding:compiler:3.1.4")


    //////////////////////////////////////////
    // third party

    // dependency injection
    val koinVersion = "1.0.2"
    implementation("org.koin:koin-androidx-scope:$koinVersion")
    implementation("org.koin:koin-androidx-viewmodel:$koinVersion")

    // networking
    val retrofitVersion = "2.3.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")

    // rx java
    val rxJavaVersion = "2.1.0"
    val rxAndroidVersion = rxJavaVersion
    implementation("io.reactivex.rxjava2:rxjava:$rxJavaVersion")
    implementation("io.reactivex.rxjava2:rxandroid:$rxAndroidVersion")
    implementation("io.reactivex.rxjava2:rxkotlin:2.3.0")


    ////////////////////////////////////////////////////
    // test

    // 1st party libs
    val espressoVersion = "3.1.1"
    val instrumentedTestVersion = "1.1.0"
    testImplementation("junit:junit:4.12")
    androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:$espressoVersion")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:$espressoVersion")
    androidTestImplementation("androidx.test:runner:$instrumentedTestVersion")
    androidTestImplementation("androidx.test:rules:$instrumentedTestVersion")
    androidTestImplementation("androidx.test.ext:junit:$instrumentedTestVersion")


    // for live data
    testImplementation("androidx.arch.core:core-testing:$lifecycleVersion")

}
