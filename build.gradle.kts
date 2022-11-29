import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val junitVersion: String = "5.9.1"
val assertkVersion: String = "0.25"

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "org.vds"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("com.willowtreeapps.assertk:assertk:$assertkVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}