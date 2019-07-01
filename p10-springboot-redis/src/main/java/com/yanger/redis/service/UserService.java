package com.yanger.redis.service;

import com.yanger.redis.dao.IUserDao;
import com.yanger.redis.po.User;
import com.yanger.redis.util.CacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private CacheDao cacheDao;

    /**
     * 添加用户
     * @param user
     */
    public int addUser(User user){
        userDao.add(user);
        // 添加缓存
        cacheDao.set("user:id:" + user.getId(), user);
        return user.getId();
    }

    /**
     * 删除用户
     * @param id
     */
    public void delUser(int id){
        userDao.del(id);
    }

    /**
     * 修改用户信息
     * @param user
     */
    // @CachePut，每次都会进行缓存添加，缓存值为方法返回值，该方法无返回值无法使用
    // @CachePut(value="user", key="'anno:user:id:' + #user.id")
    // 直接删除缓存，下次获取重新查库
    @CacheEvict(value="user", key="'anno:user:id:' + #user.id")
    public void updateUser(User user){
        userDao.update(user);
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    public User getUser(int id){
        // 从缓存中获取
        User user = (User)cacheDao.get("user:id:" + id);
        if(user == null){
            user = userDao.find(id);
            cacheDao.set("user:id:" + user.getId(), user);
        }
        return user;
    }

    /**
     * 获取用户信息，注解缓存
     * @param id
     * @return
     */
    // @Cacheable存在缓存则从缓存中获取，不存在则进行缓存，缓存值为方法返回值
    @Cacheable(value="user", key="'anno:user:id:' + #id")
    public User getUserAnno(int id){
        return userDao.find(id);
    }

    /**
     * 获取全部用户信息
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 获取用户
     * @param username
     * @param password
     * @return
     */
    public User getUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        return user;
    }

}
