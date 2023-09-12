plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.0.0"
    application
}

val nitricVersion: String by rootProject.extra

project.setProperty("mainClassName", "org.example.GoodbyeApp")

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("com.github.nitrictech:jvm-sdk:$nitricVersion")
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