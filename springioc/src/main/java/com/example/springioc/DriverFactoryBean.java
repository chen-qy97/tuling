package com.example.springioc;

import org.springframework.beans.factory.FactoryBean;

import java.sql.DriverManager;

/*FactoryBean  创建目标对象的封装*/
/*应用场景： FactoryBean  帮助我们自定的创建bean 设置格式以及类别*/
public class DriverFactoryBean implements FactoryBean {
    private String jdbcUrl;

    @Override
    public Object getObject() throws Exception {
        return DriverManager.getDriver(jdbcUrl);
    }

    @Override
    public Class<?> getObjectType() {
        return java.sql.Driver.class;
    }

    /**
     * 是一个单例模式
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
