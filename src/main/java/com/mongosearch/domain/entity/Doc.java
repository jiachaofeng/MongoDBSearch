package com.mongosearch.domain.entity;

import com.mongosearch.util.JacksonUtil;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "Doc")
public class Doc implements Serializable {
    public Doc() {
    }

    public Doc(String type, String subType1, String subType2, String subType3, Object doctDtl) {
        this.type = type;
        this.subType1 = subType1;
        this.subType2 = subType2;
        this.subType3 = subType3;
        this.doctDtl = doctDtl;
    }

    public String toString(){
        return JacksonUtil.objectToJson(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType1() {
        return subType1;
    }

    public void setSubType1(String subType1) {
        this.subType1 = subType1;
    }

    public String getSubType2() {
        return subType2;
    }

    public void setSubType2(String subType2) {
        this.subType2 = subType2;
    }

    public String getSubType3() {
        return subType3;
    }

    public void setSubType3(String subType3) {
        this.subType3 = subType3;
    }

    public Object getDocDtl() {
        return doctDtl;
    }

    public void setDocDtl(Object doctDtl) {
        this.doctDtl = doctDtl;
    }

    @TextIndexed
    private String type;
    @TextIndexed
    private String subType1;
    @TextIndexed
    private String subType2;
    @TextIndexed
    private String subType3;
    private Object doctDtl;

}
