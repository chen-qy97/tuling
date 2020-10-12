package com.mybatis.demo.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from test1")
    List<Map<String, Object>> query();
}
