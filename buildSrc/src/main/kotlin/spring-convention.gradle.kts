plugins {
        id("kotlin-convention")
        id("org.springframework.boot")
        id("io.spring.dependency-management")
        id("org.jetbrains.kotlin.plugin.spring")
        id("org.jetbrains.kotlin.plugin.allopen")
}

repositories {
        mavenCentral()
}

dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
}