package com.example.tuling.mybatis.mapper;

import com.example.tuling.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User selectUser(Integer id);

}
