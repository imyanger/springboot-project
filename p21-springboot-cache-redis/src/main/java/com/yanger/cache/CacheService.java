package com.yanger.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanger
 * @description service层
 * @date 2019/10/12
 */
@Slf4j
@Service
public class CacheService {

    private Map<Integer, User> dataMap = new HashMap <Integer, User>(){
        {
            for (int i = 1; i < 100 ; i++) {
                User u = new User("code" + i, "name" + i);
                put(i, u);
            }
        }
     };

    // 获取数据
    @Cacheable(value = "cache", key = "'user:' + #id")
    public User get(int id){
        log.info("通过id{}查询获取", id);
        return dataMap.get(id);
    }

    // 更新数据
    @CachePut(value = "cache", key = "'user:' + #id")
    public User set(int id, User u){
        log.info("更新id{}数据", id);
        dataMap.put(id, u);
        return u;
     }

    //删除数据
    @CacheEvict(value = "cache", key = "'user:' + #id")
    public void del(int id){
        log.info("删除id{}数据", id);
        dataMap.remove(id);
    }

}
