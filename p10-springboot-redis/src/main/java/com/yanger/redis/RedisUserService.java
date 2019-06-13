package com.yanger.redis;

import com.yanger.jdbcTemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisUserService {

    @Autowired
    private RedisDao userDao;

    @Autowired
    private CacheDao cacheDao;

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user){
        userDao.add(user);
        // 添加缓存
        cacheDao.set(user.getId().toString(), user);
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
        User user = (User)cacheDao.get("" + id);
        if(user != null){
            return user;
        }
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
