package com.yanger.mybatis.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为" + DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }

}
