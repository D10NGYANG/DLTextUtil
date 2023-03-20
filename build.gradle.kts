plugins {
    kotlin("jvm") version "1.8.10"
    id("maven-publish")
}

group = "com.github.D10NGYANG"
version = "1.4.1"

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
    // 拼音处理
    api("io.github.biezhi:TinyPinyin:2.0.3.RELEASE")
}

val bds100MavenUsername: String by project
val bds100MavenPassword: String by project

publishing {
    publications {
        create("release", MavenPublication::class) {
            artifactId = "DLTextUtil"
            from(components.getByName("java"))
        }
    }
    repositories {
        maven {
            url = uri("/Users/d10ng/project/kotlin/maven-repo/repository")
        }
        maven {
            credentials {
                username = bds100MavenUsername
                password = bds100MavenPassword
            }
            setUrl("https://nexus.bds100.com/repository/maven-releases/")
        }
    }
}