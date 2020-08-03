package com.example.tuling.mybatis.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String username;
    private Integer age;
    private String phone;
    private String desc;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
