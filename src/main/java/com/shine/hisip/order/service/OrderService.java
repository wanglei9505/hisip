package com.shine.hisip.order.service;

import com.github.pagehelper.Page;
import com.shine.hisip.common.domain.OrderInfo;
import com.shine.hisip.order.dto.CountDto;
import com.shine.hisip.order.dto.OrderDto;

/**
 * @Author: a
 * @DATE: Created in 2018/1/23
 **/
public interface OrderService {
    Page<OrderDto> getOrderByOpenId(OrderDto record);
    OrderDto getOrderDetail(OrderDto record);
    String insert(OrderInfo record);
    CountDto count(String doctorId);
}
