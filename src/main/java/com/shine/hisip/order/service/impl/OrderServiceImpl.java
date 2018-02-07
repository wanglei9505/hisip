package com.shine.hisip.order.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shine.hisip.common.domain.OrderInfo;
import com.shine.hisip.common.response.enumeration.ResponseStatus;
import com.shine.hisip.order.dao.OrderInfoMapper;
import com.shine.hisip.order.dto.CountDto;
import com.shine.hisip.order.dto.OrderDto;
import com.shine.hisip.order.service.OrderService;
import com.shine.hisip.source.dao.SourceInfoMapper;
import com.shine.hisip.source.dto.AppointInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: a
 * @DATE: Created in 2018/1/23
 **/
@Service
@Transactional(rollbackFor=Exception.class)
public class OrderServiceImpl implements OrderService {
    //订单记录mapper
    @Autowired
    private OrderInfoMapper orderMapper;
    //号源mapper
    @Autowired
    private SourceInfoMapper sourceMapper;
    @Override
    public Page<OrderDto> getOrderByOpenId(OrderDto record) {
        PageHelper.startPage(record.getCurrentPage(),record.getPageSize());
        return orderMapper.getOrderByOpenId(record);
    }

    @Override
    public OrderDto getOrderDetail(OrderDto record) {
        return orderMapper.getOrderDetail(record);
    }

    @Override
    public String insert(OrderInfo record) {
        record.setCreateTime(new Date());
        record.setStatus("001");
        //todo 调用HIS 接口完成号源锁定
        AppointInfo appInfo=sourceMapper.getAppInfoById(record.getSourceId());
        if(appInfo == null || appInfo.getAppointNum() == null || appInfo.getAppointNum() == 0 || appInfo.getAppointNum() < 0){
            throw new RuntimeException("号源已空，请选择其他时间段");
        }
        orderMapper.insertSelective(record);
        sourceMapper.reserve(record.getSourceId());
        return record.getId();
    }

    /**
     * 周、月预约量统计
     * @param doctorId
     * @return
     */
    @Override
    public CountDto count(String doctorId) {
        CountDto count=new CountDto();
        count.setWeekConut(orderMapper.weekCount(doctorId));
        count.setMonthConut(orderMapper.monthCount(doctorId));
        return count;
    }
}
