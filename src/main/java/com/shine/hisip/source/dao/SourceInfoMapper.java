package com.shine.hisip.source.dao;

import com.shine.hisip.common.domain.SourceInfo;
import com.shine.hisip.doctor.dto.DoctorReq;
import com.shine.hisip.source.dto.AppointInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SourceInfoMapper {
    /**
     * 获取医生排班信息
     * @param doctorReq
     * @return
     */
    List<AppointInfo> getAppInfo(DoctorReq doctorReq);

    /**
     * 获取单条号源记录
     * @param id
     * @return
     */
    AppointInfo getAppInfoById(String id);

    int add(SourceInfo record);

    int edit(SourceInfo record);

    /**
     * 预约 号源数减一
     * @param id
     * @return
     */
    int reserve(String id);

    int insert(SourceInfo record);

    int deleteByPrimaryKey(String id);
}