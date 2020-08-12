package com.example.mybatis03.mapper;

import com.example.mybatis03.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper  {

    @Select("select id,username,age,[hone, `desc` from user where id = #{id}")
    User selectUser(int id);
}
