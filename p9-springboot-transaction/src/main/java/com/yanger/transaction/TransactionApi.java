package com.yanger.transaction;

import com.yanger.jdbcTemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// https://blog.csdn.net/mingyundezuoan/article/details/79017659
@RestController
@RequestMapping("transaction")
public class TransactionApi {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("no")
    public void addNoTransaction(@RequestBody User user){
        transactionService.addNo(user);
    }

    @PostMapping("with")
    public void addWithTransaction(@RequestBody User user){
        transactionService.addWith(user);
    }

    @GetMapping("find")
    public User find(@RequestParam String username){
        return transactionService.findByName(username);
    }

}
