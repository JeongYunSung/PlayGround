plugins {
        id("kotlin-convention")
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
