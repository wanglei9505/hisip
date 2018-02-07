package com.shine.hisip.doctor.dto;

import com.shine.hisip.source.dto.AppointInfo;

import java.util.Date;


/**
 * @Author: a
 * @DATE: Created in 2018/1/24
 **/
public class DoctorInfoDto extends DoctorBase {
    //最近号源日期
    private Date recentDate;
    //病症名称
    private String diseaseName;
    //号源状态
    private String doctorStatus;
    //根据时间的单条记录
    private AppointInfo appointInfo;

    public Date getRecentDate() {
        return recentDate;
    }

    public void setRecentDate(Date recentDate) {
        this.recentDate = recentDate;
    }

    public String getDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(String doctorStatus) {
        this.doctorStatus = doctorStatus;
    }

    public AppointInfo getAppointInfo() {
        return appointInfo;
    }

    public void setAppointInfo(AppointInfo appointInfo) {
        this.appointInfo = appointInfo;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
}
