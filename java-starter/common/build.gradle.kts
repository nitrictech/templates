plugins {
    id("java")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("com.github.nitrictech:jvm-sdk:v0.1.1")
}

tasks.test {
    useJUnitPlatform()
}