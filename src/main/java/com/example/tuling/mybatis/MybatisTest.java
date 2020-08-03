package com.example.tuling.mybatis;

import com.example.tuling.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//@Slf4j
public class MybatisTest {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("com.example.tuling.mybatis.mapper.UserMapper.selectUser" ,1);
            System.out.println(user);
            //log.info("user: {}",user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
