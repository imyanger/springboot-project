package com.yanger.mybatis.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        if(StringUtils.isEmpty("数据源为" + DataSourceContextHolder.getDB())){
            System.out.println("使用默认数据源");
        }else {
            System.out.println("数据源为" + DataSourceContextHolder.getDB());
        }
        return DataSourceContextHolder.getDB();
    }

}
