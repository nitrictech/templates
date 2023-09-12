pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    
}
rootProject.name = "kotlin-starter"

include("hello-service")
include("goodbye-service")
include("common")
