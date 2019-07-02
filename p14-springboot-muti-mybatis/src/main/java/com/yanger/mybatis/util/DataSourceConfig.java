package com.yanger.mybatis.util;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.logging.stdout.StdOutImpl;
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

    /**
     * mybatis的configuration设置
     * @return
     */
    @Bean
    org.apache.ibatis.session.Configuration masterConfiguration(){
        // 添加sql打印，即配置文件中mybatis.configuration.log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl .class);
        return configuration;
    }

    // 必须得使用不同的Configuration对象，否则数据源加载会出现覆盖
    @Bean
    org.apache.ibatis.session.Configuration slaveConfiguration(){
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl .class);
        return configuration;
    }

}
