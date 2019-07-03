package com.yanger.jdbcTemplate.dao;

import com.yanger.jdbcTemplate.po.User;

import java.util.List;

public interface IUserDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addSlave(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int del(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User find(int id);

    /**
     * 获取全部用户
     * @return
     */
    List<User> findAll();

    /**
     * slave获取全部用户
     * @return
     */
    List<User> findAllSlave();

}
