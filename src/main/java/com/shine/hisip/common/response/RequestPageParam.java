package com.shine.hisip.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 分页参数
 * Created by Hyun on 2017/11/23.
 */
public class RequestPageParam {

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
