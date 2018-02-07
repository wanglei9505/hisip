package com.shine.hisip.order.dto;

/**
 * @Author: a
 * @DATE: Created in 2018/1/30
 * 医生工作量统计
 **/
public class CountDto {
    private Integer weekConut;
    private Integer monthConut;

    public Integer getMonthConut() {
        return monthConut;
    }

    public void setMonthConut(Integer monthConut) {
        this.monthConut = monthConut;
    }

    public Integer getWeekConut() {
        return weekConut;
    }

    public void setWeekConut(Integer weekConut) {
        this.weekConut = weekConut;
    }
}
