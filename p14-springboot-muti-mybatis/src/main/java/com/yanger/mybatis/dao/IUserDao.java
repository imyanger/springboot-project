package com.yanger.mybatis.dao;

import com.yanger.mybatis.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // IUserDao注入名重复
public interface IUserDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("insert into user(username, password) values(#{username}, #{password})")
    int add(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{id}")
    int del(@Param("id") int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    int update(User user);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User find(@Param("id") int id);

    /**
     * 获取全部用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
