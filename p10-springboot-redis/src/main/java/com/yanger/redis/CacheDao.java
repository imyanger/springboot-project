package com.yanger.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class CacheDao {

    @Resource
    private RedisTemplate<String, Object> template;

    public void set(String key, Object value){
        System.out.print("添加缓存key->" + key);
        ValueOperations<String, Object> valueOperations = template.opsForValue();
        // 1分钟过期
        valueOperations.set(key, value, 1, TimeUnit.MINUTES);
    }

    public Object get(String key){
        System.out.print("获取缓存key->" + key);
        ValueOperations<String, Object> valueOperations = template.opsForValue();
        return valueOperations.get(key);
    }


}
