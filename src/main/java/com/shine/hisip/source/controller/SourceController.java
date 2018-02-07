package com.shine.hisip.source.controller;

import com.shine.hisip.common.BaseController;
import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.common.response.enumeration.ResponseStatus;
import com.shine.hisip.doctor.dto.DoctorReq;
import com.shine.hisip.source.dto.AppointInfo;
import com.shine.hisip.source.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/29
 **/
@RestController
@RequestMapping("/source")
public class SourceController extends BaseController{
    @Autowired
    private SourceService sourceService;

    /**
     * 医生排班信息
     * @param req
     * @return
     */
    @RequestMapping(value = "/plan",method = RequestMethod.GET)
    public ResponseCom appointByDoct(DoctorReq req){
        ResponseCom<AppointInfo> res=ResponseCom.newInstance();
        if (req.getDoctorId() ==  null || req.getDoctorId().equals(' ') || req.getStartDate() == null){
            res.setResultCode(ResponseStatus.PARAM_MISSED.getCode());
            res.setResultInfo(ResponseStatus.PARAM_MISSED.getNote());
            return res;
        }
        List<AppointInfo> list=sourceService.getAppInfo(req);
        res.setList(list);
        return res;
    }

    /**
     * 查询号源是否为空
     * @param id 号源ID
     * @return
     */
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public ResponseCom appointById(String id){
        ResponseCom<AppointInfo> res=ResponseCom.newInstance();
        AppointInfo appInfo=sourceService.getAppInfoById(id);
        if(appInfo == null || appInfo.getAppointNum() == null || appInfo.getAppointNum() == 0 || appInfo.getAppointNum() < 0){
            res.setResultCode(ResponseStatus.OPRERATE_FAILED.getCode());
            res.setResultInfo("号源已空，请选择其他时间段");
        }
//        res.setObj(appInfo);
        return res;
    }

    /**
     *  号源减一
     * @param id 号源ID
     * @return
     */
    @RequestMapping(value = "/reserve",method = RequestMethod.POST)
    public ResponseCom reserve(String id){
        ResponseCom<AppointInfo> res=ResponseCom.newInstance();
        int result=sourceService.reserve(id);
        return res;
    }

}
