package com.example.tuling.mybatis.mapper;

import com.example.tuling.mybatis.pojo.Sex;
import org.apache.ibatis.annotations.Select;

public interface SexMapper {

    @Select("select * from sex where id = #{id}")
    public Sex selectUser(Integer id);

}
