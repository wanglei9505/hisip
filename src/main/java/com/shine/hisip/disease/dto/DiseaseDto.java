package com.shine.hisip.disease.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Author: a
 * @DATE: Created in 2018/2/5
 **/
public class DiseaseDto {
    private String id;

    private String diseaseName;

    private String type;

    private Short sortN0;
    @JsonIgnore
    private int currentPage;    //当前页码
    @JsonIgnore
    private int pageSize;       //大小

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getSortN0() {
        return sortN0;
    }

    public void setSortN0(Short sortN0) {
        this.sortN0 = sortN0;
    }
}
