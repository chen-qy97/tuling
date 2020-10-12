package com.mybatis.demo.test;

import com.mybatis.demo.app.AppConfig;
import com.mybatis.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMapper {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ac.getBean(UserService.class).query();
    }

}
