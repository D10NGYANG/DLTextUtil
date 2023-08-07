plugins {
    kotlin("jvm") version "1.9.0"
    id("maven-publish")
    id("com.github.ben-manes.versions") version "0.47.0"
}

group = "com.github.D10NGYANG"
version = "1.4.3"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

kotlin {
    jvmToolchain(8)
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

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}