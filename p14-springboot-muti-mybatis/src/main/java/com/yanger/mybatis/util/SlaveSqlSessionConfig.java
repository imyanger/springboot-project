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

@Configuration
@MapperScan(
        basePackages = {"com.yanger.mybatis.sdao"}, //mapper生效的包
        sqlSessionFactoryRef = "slaveSqlSessionFactory" //mybatis依赖的SqlSessionFactory
)
public class SlaveSqlSessionConfig {

    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource slaveDataSource;

    @Autowired
    private org.apache.ibatis.session.Configuration slaveConfiguration;

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(slaveDataSource);
        // mapper映射的xml文件的位置，因为该工程mybatis是基于注解，所以不用设置
        //sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(""));
        sessionFactory.setConfiguration(slaveConfiguration);
        return sessionFactory.getObject();
    }

    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager slaveTransactionManager() {
        return new DataSourceTransactionManager(slaveDataSource);
    }

}
