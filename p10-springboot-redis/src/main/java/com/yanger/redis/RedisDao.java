package com.yanger.redis;

import com.yanger.jdbcTemplate.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
//@Repository // @Repository无法注入接口，可以启动类加@ComponentScan或者@MapperScan
public interface RedisDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("insert into user(username, password) values(#{username}, #{password})")
    // 自增长主键之后获取主键需要设置属性@Options(useGeneratedKeys = true, keyProperty = "id")
    // 如果是基于xml则insert标签中添加属性keyProperty="id" useGeneratedKeys="true"
    @Options(useGeneratedKeys = true, keyProperty = "id")
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
