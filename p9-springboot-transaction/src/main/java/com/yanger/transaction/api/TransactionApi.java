package com.yanger.transaction.api;

import com.yanger.mybatis.po.User;
import com.yanger.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 关于事务注解：https://blog.csdn.net/mingyundezuoan/article/details/79017659
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
