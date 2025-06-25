plugins {
    java
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.magicgopher.study"
version = "1.0-SNAPSHOT"
description = "jpa study example05"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    sourceCompatibility = JavaVersion.VERSION_21 // 指定 Java 源代码版本为 Java 21，支持 Java 21 的语法和特性
    targetCompatibility = JavaVersion.VERSION_21 // 指定编译后字节码的目标 JVM 版本为 Java 21，确保兼容 Java 21 的运行环境
}

repositories {
    mavenCentral()
}

val postgresqlVersion = "42.7.7" // PostgreSQL 驱动版本
val mysqlVersion = "9.2.0" // MySQL 驱动版本

dependencies {
    //
    implementation("org.springframework.boot:spring-boot-starter")

    // Spring Data JPA 启动器
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // PostgreSQL 数据库驱动
    implementation("org.postgresql:postgresql:$postgresqlVersion")

    // MySQL 数据库驱动
    implementation("com.mysql:mysql-connector-j:$mysqlVersion")

    // Spring Boot Test 启动器
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
    // 只显示测试失败或错误的信息
    testLogging {
        events("passed", "skipped", "failed") // 显示通过、跳过、失败的测试事件
        showStandardStreams = false // 禁用标准输出和标准错误（减少日志）
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL // 显示完整的异常堆栈
        showCauses = true // 显示异常原因
        showStackTraces = true // 显示堆栈跟踪
    }
}