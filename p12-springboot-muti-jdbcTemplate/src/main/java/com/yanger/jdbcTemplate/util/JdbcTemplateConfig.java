package com.yanger.jdbcTemplate.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    @Bean
    JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource")DataSource masterDataSource){
        return new JdbcTemplate(masterDataSource);
    }

    @Bean
    JdbcTemplate slaveJdbcTemplate(@Qualifier("slaveDataSource")DataSource slaveDataSource){
        return new JdbcTemplate(slaveDataSource);
    }

}
