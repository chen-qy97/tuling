package com.example.mybatis04.session;

import com.example.mybatis04.executor.Executor;

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    @Override
    public <T>T selectOne(String statement){
       return null;
    }

}
