package com.yanger.jpa.sdao;

import com.yanger.jpa.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISlaveUserDao extends JpaRepository<User, Integer> {

}
