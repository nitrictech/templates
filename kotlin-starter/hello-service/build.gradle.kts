import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val nitricVersion: String by rootProject.extra

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "7.0.0"
    application
}

project.setProperty("mainClassName", "HelloAppKt")

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("com.github.nitrictech:jvm-sdk:$nitricVersion")
    implementation(project(":common"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.shadowJar {
    mergeServiceFiles()
}


application {
    mainClass.set("HelloAppKt")
}