package com.yanger.mybatis.service;

import com.yanger.mybatis.dao.IUserDao;
import com.yanger.mybatis.po.User;
import com.yanger.mybatis.sdao.ISlaveUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private ISlaveUserDao iSlaveUserDao;

    /**
     * 添加用户
     * @param user
     */
    @Transactional(value = "masterTransactionManager")
    public void addUser(User user){
        userDao.add(user);
        // 除零异常，测试事务
        int a = 1/0;
    }

    /**
     * 添加用户
     * @param user
     */
    @Transactional(value = "slaveTransactionManager")
    public void addUserSlave(User user){
        iSlaveUserDao.add(user);
        // 除零异常，测试事务
        int a = 1/0;
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
     * slave获取全部用户信息
     * @return
     */
    public List<User> findAllSlave() {
        return iSlaveUserDao.findAll();
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
