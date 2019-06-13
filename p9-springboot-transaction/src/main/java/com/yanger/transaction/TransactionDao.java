package com.yanger.transaction;

import com.yanger.jdbcTemplate.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TransactionDao {

    @Insert("insert into user(username, password) values(#{username}, #{password})")
    void insert(User user);

    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username") String username);

}
