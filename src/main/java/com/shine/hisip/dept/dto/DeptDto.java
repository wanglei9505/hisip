package com.shine.hisip.dept.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shine.hisip.common.domain.DeptInfo;

/**
 * @Author: a
 * @DATE: Created in 2018/1/24
 **/
public class DeptDto extends DeptInfo {
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
}
