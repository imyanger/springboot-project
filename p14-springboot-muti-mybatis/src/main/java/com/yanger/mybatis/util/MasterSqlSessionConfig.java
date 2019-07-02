package com.yanger.mybatis.util;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.lang.annotation.Annotation;

@Configuration
@MapperScan(
        basePackages = {"com.yanger.mybatis.dao"}, //mapper生效的包
        sqlSessionFactoryRef = "masterSqlSessionFactory" //mybatis依赖的SqlSessionFactory
)
public class MasterSqlSessionConfig {

    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;

    @Autowired
    org.apache.ibatis.session.Configuration masterConfiguration;

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        // mapper映射的xml文件的位置，因为该工程mybatis是基于注解，所以不用设置
        //sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(""));
        sessionFactory.setConfiguration(masterConfiguration);
        return sessionFactory.getObject();
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource);
    }

}
