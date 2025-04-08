plugins {
        id("kotlin-convention")
        id("org.springframework.boot")
}

repositories {
        mavenCentral()
}

dependencies {
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
}
