package com.yanger.jpa.service;

import com.yanger.jpa.dao.IUserDao;
import com.yanger.jpa.po.User;
import com.yanger.jpa.sdao.ISlaveUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    // 需要指明value属性，否则会使用默认的事务管理，即@Primary声明的那一个
    @Transactional(value = "masterTransactionManager")
    public void addUser(User user){
        userDao.save(user);
        // 除零异常，测试事务
        int a =1/0;
    }

    /**
     * 添加用户
     * @param user
     */
    // 需要指明value属性，否则会使用默认的事务管理，即@Primary声明的那一个
    @Transactional(value = "slaveTransactionManager")
    public void addUserSlave(User user){
        iSlaveUserDao.save(user);
        // 除零异常，测试事务
        int a =1/0;
    }

    /**
     * 删除用户
     * @param id
     */
    public void delUser(int id){
        userDao.deleteById(id);
    }

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user){
        Optional<User> opt = userDao.findById(user.getId());
        opt.get().setPassword(user.getPassword());
        opt.get().setUsername(user.getUsername());
        userDao.save(opt.get());
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    public User getUser(int id){
        return userDao.findById(id).get();
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
        User user1 = userDao.findByUsernameAndPassword(username, password);
        User user2 = userDao.find(username, password);
        return user1;
    }

}
