package com.example.swaggedemo.mybatis.pojo;
import java.io.Serializable;
import java.util.Date;

public class Sex implements Serializable {

    private Integer id;
    private Integer sex;
    private String sexName;
    private String tenantId;
    private Date workEndTime;
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
