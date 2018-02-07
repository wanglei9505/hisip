package com.shine.hisip.source.service.impl;

import com.shine.hisip.doctor.dto.DoctorReq;
import com.shine.hisip.source.dao.SourceInfoMapper;
import com.shine.hisip.source.dto.AppointInfo;
import com.shine.hisip.source.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/29
 **/
@Service
@Transactional(rollbackFor=Exception.class)
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceInfoMapper sourceMapper;
    @Override
    public List<AppointInfo> getAppInfo(DoctorReq doctorReq) {
        return sourceMapper.getAppInfo(doctorReq);
    }

    @Override
    public AppointInfo getAppInfoById(String id) {
        return sourceMapper.getAppInfoById(id);
    }

    @Override
    public int reserve(String id) {
       return sourceMapper.reserve(id);
    }
}
