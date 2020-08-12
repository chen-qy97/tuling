package com.example.mybatis03;

import com.example.mybatis03.entity.User;
import com.example.mybatis03.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-mybatis.xml"})
@Slf4j
public class MybatisTest2 {

    @Autowired
    private UserMapper userMapper;

    public void testUserMapper(){
        User user = userMapper.selectUser(1);
        log.info("user: {}", user);
    }

}
