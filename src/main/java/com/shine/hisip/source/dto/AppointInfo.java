package com.shine.hisip.source.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: a
 * @DATE: Created in 2018/1/25
 * 号源信息
 **/
public class AppointInfo {

    private String id;

    private String doctorId;

    private Date appointDate;

    private String appointTime;

    private Short appointNum;

    private BigDecimal charge;

    private String appointType;

    private Short status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Date getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public Short getAppointNum() {
        return appointNum;
    }

    public void setAppointNum(Short appointNum) {
        this.appointNum = appointNum;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public String getAppointType() {
        return appointType;
    }

    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }

}
