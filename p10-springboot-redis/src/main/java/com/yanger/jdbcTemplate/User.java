package com.yanger.jdbcTemplate;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user")
@Entity
// DefaultSerializer requires a Serializable payload but received an object of type [com.yanger.jdbcTemplate.User]
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 使用数据库的主键自增策略
    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
