package com.example.springtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    AccountService accountService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(String name) {
        //插入user记录
        jdbcTemplate.update("insert into `user` (name) values (?)", name);
        //调用accountService添加账户
        accountService.addAccount(name, 10000);

    }
}
