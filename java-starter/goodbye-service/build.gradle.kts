plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.0.0"
    application
}

project.setProperty("mainClassName", "org.example.GoodbyeApp")

group = "org.example"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("com.github.nitrictech:jvm-sdk:v0.1.0")
    implementation(project(":common"))
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    mergeServiceFiles()
}

application {
    mainClass.set("org.example.GoodbyeApp")
}