package com.example.tuling.mybatis;

import com.example.tuling.mybatis.mapper.UserMapper;
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

        /* 通过xml配置文件执行sql */
        testForXml(resource);

        /* 通过注解的方式来执行sql */
        testForAnnotation(resource);

    }

    public static void testForXml(String resource){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();
            /*mybatis-config.xml 配置  <mapper resource="mybatis/UserMapping.xml"/> */
            User user = sqlSession.selectOne("com.example.tuling.mybatis.mapper.UserMapper.selectUser" ,1);
            System.out.println(user);
            //log.info("user: {}",user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testForAnnotation(String resource){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();
            /*mybatis-config.xml 配置  <mapper resource="com.example.tuling.mybatis.mapper.UserMapper"></mapper> */
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUser(1);
            System.out.println(user);
            //log.info("user: {}",user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
