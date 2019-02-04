plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.11")
}

repositories {
    jcenter()
}

tasks.register("printer") {
    project.properties.forEach {
        println("${it.key} => ${it.value}")
    }
}
