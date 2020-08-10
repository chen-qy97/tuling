package com.example.tuling.mybatis;

import com.example.tuling.mybatis.mapper.UserMapper;
import com.example.tuling.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis一级缓存只作用于一个session
 *
 *
 * 二级缓存作用于全局
 * 开启二级缓存：mybatis-config.xml  setting配置
 */
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

            /* sqlSession 一级缓存的作用域 */
            SqlSession sqlSession = sqlSessionFactory.openSession();
            /*mybatis-config.xml 配置  <mapper resource="mybatis/UserMapping.xml"/> */
            User user = sqlSession.selectOne("com.example.tuling.mybatis.mapper.UserMapper.selectUser" ,1);
            User user2 = sqlSession.selectOne("com.example.tuling.mybatis.mapper.UserMapper.selectUser" ,1);
            sqlSession.commit();

            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            /*mybatis-config.xml 配置  <mapper resource="mybatis/UserMapping.xml"/> */
            User user3 = sqlSession1.selectOne("com.example.tuling.mybatis.mapper.UserMapper.selectUser" ,1);
            User user4 = sqlSession1.selectOne("com.example.tuling.mybatis.mapper.UserMapper.selectUser" ,1);
            sqlSession1.commit();

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
