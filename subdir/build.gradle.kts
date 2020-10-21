buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    id("org.gradle.test-retry") version "1.1.9"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter-params:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.withType<Test> {
    useJUnitPlatform()

    retry {
        maxRetries.set(3)
        maxFailures.set(20)
        failOnPassedAfterRetry.set(false)
    }
}
