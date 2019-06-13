package com.yanger.transaction;

import com.yanger.jdbcTemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;


    public void addNo(User user){
        transactionDao.insert(user);
        int a = 1/0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addWith(User user){
        transactionDao.insert(user);
        int a = 1/0;
    }

    @Transactional(readOnly = true)
    public User findByName(String username){
        return transactionDao.findByUsername(username);
    }

}
