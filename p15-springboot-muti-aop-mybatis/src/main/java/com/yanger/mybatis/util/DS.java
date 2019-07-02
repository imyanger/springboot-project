package com.yanger.mybatis.util;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DS {

    String value() default DataSourceContextHolder.DEFAULT_DATASOURCE;

}
