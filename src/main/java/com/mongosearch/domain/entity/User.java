package com.mongosearch.domain.entity;

import com.mongosearch.util.JacksonUtil;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
    public User() {
    }

    public User(String userName, String pwd, String remark) {
        this.userName = userName;
        this.pwd = pwd;
        this.remark = remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString(){
        return JacksonUtil.objectToJson(this);
    }

    @TextIndexed
    private String userName;
    private String pwd;
    @TextIndexed
    private String remark;
}
