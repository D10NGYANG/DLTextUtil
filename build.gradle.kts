plugins {
    kotlin("jvm") version "1.6.10"
    id("maven-publish")
}

group = "com.github.D10NGYANG"

repositories {
    mavenCentral()
    maven("https://jitpack.io" )
}

kotlin {
    java {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    // 协程
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}

publishing {
    publications {
        create("maven_public", MavenPublication::class) {
            from(components.getByName("java"))
        }
    }
}