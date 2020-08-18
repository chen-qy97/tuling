package com.example.springtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class AccountServiceImpl implements AccountService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addAccount(String name, int initMoney) {
        String accountid = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        jdbcTemplate.update("insert into account (accountName, user, money) values (?, ?, ?)", accountid);
    }

    @Override
    public List<Account> queryAccount(String name) {
        List<Account> list = jdbcTemplate.queryForList("select * from account wherer user=?", Account.class);
        return list;
    }

    @Override
    public int updateAccount(String name, int money) {
        return jdbcTemplate.update("select * from account set money=money+? where user=?", money, name);
    }
}
