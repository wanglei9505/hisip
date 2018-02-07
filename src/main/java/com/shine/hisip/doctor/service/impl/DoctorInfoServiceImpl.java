package com.shine.hisip.doctor.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shine.hisip.common.domain.DoctorInfo;
import com.shine.hisip.doctor.dao.DoctorInfoMapper;
import com.shine.hisip.doctor.dto.DoctorInfoDto;
import com.shine.hisip.doctor.dto.DoctorReq;
import com.shine.hisip.doctor.service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/26
 **/
@Service
public class DoctorInfoServiceImpl implements DoctorInfoService {
    @Autowired
    private DoctorInfoMapper doctorMapper;
    @Override
    public Page<DoctorInfoDto> listDoctorByDept(DoctorReq doctorReq) {
        PageHelper.startPage(doctorReq.getCurrentPage(),doctorReq.getPageSize());
        return doctorMapper.listDoctorByDept(doctorReq);
    }

    @Override
    public Page<DoctorInfoDto> listDoctorByDate(DoctorReq doctorReq) {
        PageHelper.startPage(doctorReq.getCurrentPage(),doctorReq.getPageSize());
        return doctorMapper.listDoctorByDate(doctorReq);
    }

    @Override
    public DoctorInfoDto getDoctorDetial(DoctorReq doctorReq) {
        return doctorMapper.getDoctorDetial(doctorReq);
    }

    @Override
    public Page<DoctorInfoDto> doctorSearch(DoctorReq doctorReq) {
        PageHelper.startPage(doctorReq.getCurrentPage(),doctorReq.getPageSize());
        return doctorMapper.doctorSearch(doctorReq);
    }

    @Override
    public Page<DoctorInfoDto> listSuggestDoctor(DoctorReq doctorReq) {
        //todo 使用字典code查询
        doctorReq.setTitle("一级专家");
        PageHelper.startPage(doctorReq.getCurrentPage(),doctorReq.getPageSize());
        return doctorMapper.listSuggestDoctor(doctorReq);
    }

    @Override
    public Page<DoctorInfoDto> doctorSearchByDisease(DoctorReq doctorReq) {
        PageHelper.startPage(doctorReq.getCurrentPage(),doctorReq.getPageSize());
        return doctorMapper.doctorSearchByDisease(doctorReq);
    }
}
