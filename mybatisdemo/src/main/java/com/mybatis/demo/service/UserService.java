package com.mybatis.demo.service;

import com.mybatis.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<Map<String, Object>> query(){
        List<Map<String, Object>> list = userMapper.query();
        System.out.println(list);
        return list;
    }
}
