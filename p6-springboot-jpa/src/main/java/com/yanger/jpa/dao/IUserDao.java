package com.yanger.jpa.dao;

import com.yanger.jpa.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserDao extends JpaRepository<User, Integer>  {

    /**
     * 根据用户名和密码查询，根据方法名来生成实体类
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return
     */
    @Query(nativeQuery = true, value = "select * from user where username = :username and password = :password")
    User find(@Param("username") String username, @Param("password") String password);

}
