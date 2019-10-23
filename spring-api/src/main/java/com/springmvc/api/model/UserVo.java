package com.springmvc.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.springmvc.api.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by xiongbanglong on 2017/4/27.
 */
public class UserVo {
    private Integer id;

    private String username;

    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;

    private String sex;

    private String address;

    public int hashCode() {
        return super.hashCode();
    }


    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}
