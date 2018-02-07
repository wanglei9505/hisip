package com.shine.hisip.doctor.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: a
 * @DATE: Created in 2018/1/26
 * 请求医生信息参数
 **/
public class DoctorReq {
    //科室ID
    private String deptId;
    //医生ID
    private String doctorId;
    //医生姓名
    private String doctorName;
    //职称
    private String title;
    //疾病名称
    private String diseaseName;
    //疾病名称
    private String diseaseId;
    //开始周一时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    //结束周日时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    //当前页码
    private int currentPage;
    //大小
    private int pageSize;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }
}
