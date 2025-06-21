package com.magicgopher.study.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @Author: MagicGopher <gopher997@gmail.com>
 * @CreateDate: 2025-06-22 03:42:37
 * @Version: v1.0.2
 * @Description: 数据源配置类
 */
@Configuration
// @PropertySource("classpath:database-mysql.properties")
@PropertySource("classpath:database-postgresql.properties")
public class DataSourceConfiguration {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 数据源
     * @return DataSource实例
     */
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setMaximumPoolSize(10);
                dataSource.setMinimumIdle(5);
        dataSource.setIdleTimeout(300000);
        dataSource.setConnectionTimeout(30000);
        dataSource.setMaxLifetime(1800000);
        dataSource.setPoolName("HikariCP-MySQL-Pool");
        return dataSource;
    }
}
