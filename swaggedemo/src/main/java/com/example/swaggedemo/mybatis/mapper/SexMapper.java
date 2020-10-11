package com.example.swaggedemo.mybatis.mapper;

import com.example.swaggedemo.mybatis.pojo.Sex;
import org.apache.ibatis.annotations.Select;

public interface SexMapper {

    @Select("select * from sex where id = #{id}")
    public Sex selectUser(Integer id);

}
