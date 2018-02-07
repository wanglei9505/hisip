package com.shine.hisip.order.dao;

import com.github.pagehelper.Page;
import com.shine.hisip.common.domain.OrderInfo;
import com.shine.hisip.order.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapper {
    //分页获取当前微信用户记录
    Page<OrderDto> getOrderByOpenId(OrderDto record);
    //获取订单详情
    OrderDto getOrderDetail(OrderDto record);
    //保存记录
    int insert(OrderInfo record);

    int weekCount(String doctorId);

    int monthCount(String doctorId);

    int deleteByPrimaryKey(String id);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}