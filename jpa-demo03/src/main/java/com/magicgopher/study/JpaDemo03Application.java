package com.magicgopher.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.magicgopher.study.repositories")  // repository 所在的包
@EntityScan(basePackages = "com.magicgopher.study.entity") // 实体所在的包
public class JpaDemo03Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemo03Application.class, args);
    }

}
