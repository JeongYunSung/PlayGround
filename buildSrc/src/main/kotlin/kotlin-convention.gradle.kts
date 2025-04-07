plugins {
        kotlin("jvm")
}

java {
        toolchain {
                languageVersion = JavaLanguageVersion.of(17)
        }
}

kotlin {
        jvmToolchain(17)
        compilerOptions {
                freeCompilerArgs.addAll("-Xjsr305=strict")
        }
}

repositories {
        mavenCentral()
}

dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
}