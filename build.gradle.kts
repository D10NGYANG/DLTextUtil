plugins {
    kotlin("jvm") version "1.6.10"
    id("maven-publish")
}

group = "com.github.D10NGYANG"
version = "1.3.0"

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
    // 单元测试
    testImplementation("junit:junit:4.13.2")
    // 协程
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    // 拼音处理
    api("io.github.biezhi:TinyPinyin:2.0.3.RELEASE")
}

publishing {
    publications {
        create("release", MavenPublication::class) {
            from(components.getByName("java"))
        }
    }
}