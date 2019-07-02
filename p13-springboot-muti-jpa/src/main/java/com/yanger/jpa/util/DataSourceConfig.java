package com.yanger.jpa.util;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary // 表示默认的数据源
    @ConfigurationProperties(prefix = "spring.datasource.master")
    DataSource masterDataSource(){
        // DataSourceBuilder.create().build();
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    DataSource slaveDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

}
