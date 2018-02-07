package com.shine.hisip.doctor.dto;

/**
 * @Author: a
 * @DATE: Created in 2018/1/26
 * 医生共用基础信息
 **/
public class DoctorBase {
    private String doctId;

    private String name;

    private String image;

    private String title;

    private String grade;
    //擅长
    private String genius;
    //介绍
    private String describe;
    //总预约量
    private Integer total;
    //科室名称
    private String deptName;
    //科室地址
    private String address;

    public String getDoctId() {
        return doctId;
    }

    public void setDoctId(String doctId) {
        this.doctId = doctId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGenius() {
        return genius;
    }

    public void setGenius(String genius) {
        this.genius = genius;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
