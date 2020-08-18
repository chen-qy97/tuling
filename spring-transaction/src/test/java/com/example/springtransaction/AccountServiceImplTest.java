package com.example.springtransaction;

import com.example.springtransaction.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceImplTest {

    @org.junit.Test
    public void addAccount() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
        AccountService service = context.getBean(AccountService.class);
        service.addAccount("luban", 10000);
    }

}
