plugins {
    id("java")
}

val nitricVersion: String by rootProject.extra

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("com.github.nitrictech:jvm-sdk:$nitricVersion")
}

tasks.test {
    useJUnitPlatform()
}