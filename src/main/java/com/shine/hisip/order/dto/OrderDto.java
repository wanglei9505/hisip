package com.shine.hisip.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shine.hisip.common.domain.OrderInfo;

/**
 * @Author: a
 * @DATE: Created in 2018/1/23
 **/
public class OrderDto extends OrderInfo {
    //状态名称
    private String statusName;
    @JsonIgnore
    private int currentPage;    //当前页码
    @JsonIgnore
    private int pageSize;       //大小

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

}
