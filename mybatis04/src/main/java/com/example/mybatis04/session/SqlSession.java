package com.example.mybatis04.session;

public interface SqlSession {

    <T>T selectOne(String statement);

}
