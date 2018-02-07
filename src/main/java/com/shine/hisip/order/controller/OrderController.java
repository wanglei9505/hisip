package com.shine.hisip.order.controller;

import com.github.pagehelper.Page;
import com.shine.hisip.common.BaseController;
import com.shine.hisip.common.domain.OrderInfo;
import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.common.response.enumeration.ResponseStatus;
import com.shine.hisip.order.dto.CountDto;
import com.shine.hisip.order.dto.OrderDto;
import com.shine.hisip.order.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: a
 * @DATE: Created in 2018/1/23
 **/
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Resource
    private OrderService orderService;

    /**
     * 根据微信用户或就诊人获取分页记录
     * @param record
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseCom listByOpenId(OrderDto record){
        ResponseCom res=ResponseCom.newInstance();
        Page<OrderDto> list=orderService.getOrderByOpenId(record);
        res.getPage().setRows(list.getResult());
        res.getPage().setTotal(list.getTotal());
        return res;
    }

    /**
     * 获取记录详情
     * @param record
     * @return
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResponseCom detail(OrderDto record){
        ResponseCom res=ResponseCom.newInstance();
        OrderDto obj=orderService.getOrderDetail(record);
        res.setObj(obj);
        return res;
    }

    /**
     * 订单保存
     * @param record
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseCom save(OrderInfo record){
        ResponseCom res=ResponseCom.newInstance();
        if(record.getSourceId() == null || record.getPatientId() == null){
            res.setResultCode(ResponseStatus.OPRERATE_FAILED.getCode());
            res.setResultInfo("就诊人或号源信息为空");
            return res;
        }
        orderService.insert(record);
        return res;
    }

    /**
     * 医生预约量
     * @param doctorId
     * @return
     */
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public ResponseCom count(String doctorId){
        ResponseCom res=ResponseCom.newInstance();
        CountDto countDto=orderService.count(doctorId);
        res.setObj(countDto);
        return res;
    }
}
