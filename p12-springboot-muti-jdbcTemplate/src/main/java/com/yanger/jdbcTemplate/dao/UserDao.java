package com.yanger.jdbcTemplate.dao;

import com.yanger.jdbcTemplate.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao implements IUserDao {

    @Autowired
    @Qualifier("masterJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Resource(name="slaveJdbcTemplate")
    private JdbcTemplate slaveJdbcTemplate;

   /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into user(username, password) value(?, ?)",
                user.getUsername(), user.getPassword());
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int addSlave(User user) {
        return slaveJdbcTemplate.update("insert into user(username, password) value(?, ?)",
                user.getUsername(), user.getPassword());
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Override
    public int del(int id) {
        return jdbcTemplate.update("delete from user where id = ?", id);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return jdbcTemplate.update("update user set username = ?, password = ? where id = ?",
                user.getUsername(), user.getPassword(), user.getId());
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @Override
    public User find(int id) {
        List<User> users = jdbcTemplate.query("select * from user where id = ?",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int i) throws SQLException {
                        User user = new User();
                        //user.setId(rs.getInt("id"));
                        user.setUsername("通过自定义RowMapper设置列：" + rs.getString("username"));
                        user.setPassword("通过自定义RowMapper设置列：" + rs.getString("password"));
                        return user;
                    }
                }, id);
        return users != null && users.size() > 0 ? users.get(0) : null;
    }

    /**
     * 获取全部用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from user ", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> findAllSlave() {
        return slaveJdbcTemplate.query("select * from user ", new BeanPropertyRowMapper<>(User.class));
    }

}
