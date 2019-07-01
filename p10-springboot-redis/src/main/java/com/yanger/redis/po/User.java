package com.yanger.redis.po;

import java.io.Serializable;

// DefaultSerializer requires a Serializable payload but received an object of type [com.yanger.redis.po.User]
public class User implements Serializable {

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
