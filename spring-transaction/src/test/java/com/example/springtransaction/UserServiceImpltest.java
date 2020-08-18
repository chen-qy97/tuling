package com.example.springtransaction;

import com.example.springtransaction.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpltest {

    @Test
    public void createUser(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
        UserService service = context.getBean(UserService.class);
        service.createUser("luban");
    }

}
