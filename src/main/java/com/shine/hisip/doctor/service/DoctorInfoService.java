package com.shine.hisip.doctor.service;

import com.github.pagehelper.Page;
import com.shine.hisip.common.domain.DoctorInfo;
import com.shine.hisip.doctor.dto.DoctorInfoDto;
import com.shine.hisip.doctor.dto.DoctorReq;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/26
 * 医生-号源信息
 **/

public interface DoctorInfoService {
    //根据科室分页获取医生信息
    Page<DoctorInfoDto> listDoctorByDept(DoctorReq doctorReq);
    //根据日期获取医生信息
    Page<DoctorInfoDto> listDoctorByDate(DoctorReq doctorReq);
    //获取医生详细信息
    DoctorInfoDto getDoctorDetial(DoctorReq doctorReq);
    //医生查询
    Page<DoctorInfoDto> doctorSearch(DoctorReq doctorReq);
    //推荐医生
    Page<DoctorInfoDto> listSuggestDoctor(DoctorReq doctorReq);
    //疾病搜索医生
    Page<DoctorInfoDto> doctorSearchByDisease(DoctorReq doctorReq);
}
