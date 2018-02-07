package com.shine.hisip.source.service;

import com.shine.hisip.doctor.dto.DoctorReq;
import com.shine.hisip.source.dto.AppointInfo;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/29
 **/
public interface SourceService {
    /**
     * 获取医生排班信息
     * @param doctorReq
     * @return
     */
    List<AppointInfo> getAppInfo(DoctorReq doctorReq);

    AppointInfo getAppInfoById(String id);

    int reserve(String id);;
}
