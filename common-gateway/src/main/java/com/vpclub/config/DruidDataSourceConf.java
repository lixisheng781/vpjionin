package com.vpclub.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


/**
 * @author vpclub
 * @date 6/4
 */
@Configuration
public class DruidDataSourceConf {
    @Bean
    public DataSource dataSource(Environment environment) {
        return DruidDataSourceBuilder.create().build(environment, "spring.datasource.druid.");
    }
}