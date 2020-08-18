package com.example.springtransaction.spring.txt;

import com.example.springtransaction.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LubanTransaction {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
        final UserService userService = context.getBean(UserService.class);

        UserService proxyUserService = (UserService) Proxy.newProxyInstance(LubanTransaction.class.getClassLoader(),
                new Class[]{UserService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                        try {
                            System.out.println("开启事物："+method.getName());
                            return method.invoke(userService, args);
                        } finally {
                            System.out.println("关闭事物："+method.getName());
                        }
                    }
                });
        proxyUserService.createUser("liban");

    }

}
