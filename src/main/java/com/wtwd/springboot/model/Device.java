package com.wtwd.springboot.model;

import java.util.Date;

public class Device {
    private Integer devId;

    private Integer devUserid;

    private String devGroup;

    private String devType;

    //这个注解是使用了com.alibaba.fastjson.annotation.JSONField
    //@JSONField(format="yyyy-MM-dd HH:mm")
    private Date devActivetime;

    private String devPower;

    //@JSONField(serialize=false)
    private String devData;

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public Integer getDevUserid() {
        return devUserid;
    }

    public void setDevUserid(Integer devUserid) {
        this.devUserid = devUserid;
    }

    public String getDevGroup() {
        return devGroup;
    }

    public void setDevGroup(String devGroup) {
        this.devGroup = devGroup == null ? null : devGroup.trim();
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType == null ? null : devType.trim();
    }

    public Date getDevActivetime() {
        return devActivetime;
    }

    public void setDevActivetime(Date devActivetime) {
        this.devActivetime = devActivetime;
    }

    public String getDevPower() {
        return devPower;
    }

    public void setDevPower(String devPower) {
        this.devPower = devPower == null ? null : devPower.trim();
    }

    public String getDevData() {
        return devData;
    }

    public void setDevData(String devData) {
        this.devData = devData == null ? null : devData.trim();
    }

    @Override
    public String toString() {
        return "Device{" +
                "devId=" + devId +
                ", devUserid=" + devUserid +
                ", devGroup='" + devGroup + '\'' +
                ", devType='" + devType + '\'' +
                ", devActivetime=" + devActivetime +
                ", devPower='" + devPower + '\'' +
                ", devData='" + devData + '\'' +
                '}';
    }
}