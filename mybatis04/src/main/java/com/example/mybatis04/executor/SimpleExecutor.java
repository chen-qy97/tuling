package com.example.mybatis04.executor;

import com.example.mybatis04.executor.Executor;

public class SimpleExecutor implements Executor {
    @Override
    public <T>T query() {
        System.out.println("+++++++++++++++++++++");
        return null;
    }
}
