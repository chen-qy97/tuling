package com.example.swaggedemo.mybatis.plugin;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

/**
 * Mybatis 将Mybatis要执行的sql拦截并打印出来
 */

@Intercepts({
      // @Signature(type = Executor.class, method = "query", args = (MappedStatement.class, Objec.class, RowBounds.class)
})
public class SqlPrintereceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
