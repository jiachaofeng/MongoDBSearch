package com.mongosearch.domain.entity;

import com.mongosearch.util.JacksonUtil;

import java.io.Serializable;

public class DocDtl implements Serializable {

    public DocDtl(String dtlType, String dtlName, String dtlUrl, String dtlRemark) {
        this.dtlType = dtlType;
        this.dtlName = dtlName;
        this.dtlUrl = dtlUrl;
        this.dtlRemark = dtlRemark;
    }

    public String toString(){
        return JacksonUtil.objectToJson(this);
    }

    public String getDtlType() {
        return dtlType;
    }

    public void setDtlType(String dtlType) {
        this.dtlType = dtlType;
    }

    public String getDtlName() {
        return dtlName;
    }

    public void setDtlName(String dtlName) {
        this.dtlName = dtlName;
    }

    public String getDtlUrl() {
        return dtlUrl;
    }

    public void setDtlUrl(String dtlUrl) {
        this.dtlUrl = dtlUrl;
    }

    public String getDtlRemark() {
        return dtlRemark;
    }

    public void setDtlRemark(String dtlRemark) {
        this.dtlRemark = dtlRemark;
    }

    private String dtlType;
    private String dtlName;
    private String dtlUrl;
    private String dtlRemark;
}
