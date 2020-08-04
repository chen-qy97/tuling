package com.example.tuling.mybatis.mapper;

import com.example.tuling.mybatis.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Mybatis之注解(annotation)和xml
 *
 * xml: 特殊字符，如>=等，需要转义
 *
 * MyBatis之#和$附
 * 相同点：1.都是对参数进行标记的符号
 *
 * #是预编译的，防止sql注入
 * $是替换参数，拼接参数，可以sql注入
 * 例如：
 *   select * from ${tablename} where id = #{id}
 *   tablename值为后台传参，id值为前端传入
 *
 */
public interface UserMapper {

    @Results(
            /*对象关系映射*/
            @Result(property = "aaa", column = "desc")
    )
    @Select("select * from user where id = #{id}")
    public User selectUser(Integer id);

}
