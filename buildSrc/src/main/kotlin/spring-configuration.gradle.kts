plugins {
        id("kotlin-convention")
        id("io.spring.dependency-management")
}

repositories {
        mavenCentral()
}

configurations {
        compileOnly {
                extendsFrom(configurations.annotationProcessor.get())
        }
}

dependencies {
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}