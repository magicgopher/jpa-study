// 应用 Java 插件，支持 Java 项目构建
plugins {
    id("java")
}

// 项目基本信息
group = "com.magicgopher.study"
version = "1.0-SNAPSHOT"
description = "jpa study example04" // 描述信息

// 仓库配置：使用 Maven Central 仓库获取依赖
repositories {
    mavenCentral()
}

// 定义依赖版本常量（相当于 Maven 的 <properties> 标签）
val springVersion = "6.2.8" // Spring 框架版本
val hibernateVersion = "6.6.1.Final" // Hibernate ORM 版本
val jpaVersion = "3.3.5" // Spring Data JPA 版本
val hikariCPVersion = "6.0.0" // HikariCP 连接池版本
val jakartaPersistenceVersion = "3.1.0" // Jakarta Persistence API 版本
val postgresqlVersion = "42.7.7" // PostgreSQL 驱动版本
val mysqlVersion = "9.2.0" // MySQL 驱动版本
val logbackVersion = "1.5.18" // SLF4J 和 Logback 日志版本
val junitVersion = "5.11.2" // JUnit 测试框架版本

// 配置 Java 版本
java {
    sourceCompatibility = JavaVersion.VERSION_21 // 指定 Java 源代码版本为 Java 21，支持 Java 21 的语法和特性
    targetCompatibility = JavaVersion.VERSION_21 // 指定编译后字节码的目标 JVM 版本为 Java 21，确保兼容 Java 21 的运行环境
}

// 项目依赖配置
dependencies {
    // Spring 核心上下文模块，提供依赖注入和 Bean 管理
    implementation("org.springframework:spring-context:$springVersion")

    // Spring 测试模块，用于单元测试和集成测试
    testImplementation("org.springframework:spring-test:$springVersion")

    // Spring Data JPA，简化 JPA 数据访问
    implementation("org.springframework.data:spring-data-jpa:$jpaVersion")

    // Jakarta Persistence API，JPA 标准接口
    implementation("jakarta.persistence:jakarta.persistence-api:$jakartaPersistenceVersion")

    // Hibernate 核心模块，JPA 的实现
    implementation("org.hibernate.orm:hibernate-core:$hibernateVersion")

    // PostgreSQL 数据库驱动
    implementation("org.postgresql:postgresql:$postgresqlVersion")

    // MySQL 数据库驱动
    implementation("com.mysql:mysql-connector-j:$mysqlVersion")

    // HikariCP 数据库连接池，高性能连接池
    implementation("com.zaxxer:HikariCP:$hikariCPVersion")

    // JUnit 5 测试框架
    testImplementation(platform("org.junit:junit-bom:$junitVersion")) // JUnit BOM 确保版本一致性
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion") // JUnit 5 测试核心库

    // SLF4J 和 Logback 日志实现，用于测试时的日志输出
    testImplementation("ch.qos.logback:logback-classic:$logbackVersion")
}

// 配置 Java 编译任务
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8" // 指定项目的字符集编码为 UTF-8，防止乱码
}

// 配置测试任务
tasks.test {
    useJUnitPlatform() // 使用 JUnit 5 平台运行测试
}