package com.magicgopher.study.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author: MagicGopher <gopher997@gmail.com>
 * @CreateDate: 2025-06-22 03:32:27
 * @Version: v1.0.2
 * @Description: 包扫描配置类，用于扫描包下配置的beans
 */
@ComponentScan(basePackages = "com.magicgopher.study")
@Import(JpaConfiguration.class)
public class PackageScanConfiguration {

}
