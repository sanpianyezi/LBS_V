package com.lbs.model;

import java.math.BigDecimal;

public class UserTrajectory {
    private Long id;

    private BigDecimal longitudePoint;

    private BigDecimal latitudePoint;

    private String address;

    private String state;

    private String userId;

    private String createTime;

    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLongitudePoint() {
        return longitudePoint;
    }

    public void setLongitudePoint(BigDecimal longitudePoint) {
        this.longitudePoint = longitudePoint;
    }

    public BigDecimal getLatitudePoint() {
        return latitudePoint;
    }

    public void setLatitudePoint(BigDecimal latitudePoint) {
        this.latitudePoint = latitudePoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}