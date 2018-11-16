package com.wzm.entran.entran.cn.util;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class OrdeUtil implements Serializable {
    private static Long serialVersionUID = 1L;
    private Integer mid;
    private Integer uid;
    private Integer number;
    private String code;

    public Integer getMid() {
        return this.mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
