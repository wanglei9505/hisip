package com.shine.hisip.common.domain;

public class DiseaseInfo {
    private String id;

    private String diseaseName;

    private String type;

    private Short sortN0;

    private String diseaseCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Short getSortN0() {
        return sortN0;
    }

    public void setSortN0(Short sortN0) {
        this.sortN0 = sortN0;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }
}