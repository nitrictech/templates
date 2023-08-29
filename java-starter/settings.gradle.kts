pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "java-starter"

include("common")
include("goodbye-service")
include("hello-service")

