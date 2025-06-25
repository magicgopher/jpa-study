package com.magicgopher.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author: MagicGopher <gopher997@gmail.com>
 * @CreateDate: 2025-06-25 04:29:21
 * @Version: v1.0.5
 * @Description: SpringBoot启动类
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.magicgopher.study.repositories")  // repository 所在的包
@EntityScan(basePackages = "com.magicgopher.study.entity") // 实体所在的包
public class JpaDemo05Application {
    public static void main(String[] args) {
        SpringApplication.run(JpaDemo05Application.class, args);
    }
}
