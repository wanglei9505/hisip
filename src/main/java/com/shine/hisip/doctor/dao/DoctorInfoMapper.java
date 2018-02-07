package com.shine.hisip.doctor.dao;

import com.github.pagehelper.Page;
import com.shine.hisip.common.domain.DoctorInfo;
import com.shine.hisip.doctor.dto.DoctorInfoDto;
import com.shine.hisip.doctor.dto.DoctorReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorInfoMapper {
    //分页按部门获取医生信息
    Page<DoctorInfoDto> listDoctorByDept(DoctorReq doctorReq);
    //分页按部门和时间获取当天排班医生
    Page<DoctorInfoDto> listDoctorByDate(DoctorReq doctorReq);
    //获取医生详细信息
    DoctorInfoDto getDoctorDetial(DoctorReq doctorReq);
    //搜索医生
    Page<DoctorInfoDto> doctorSearch(DoctorReq doctorReq);
    //推荐医生
    Page<DoctorInfoDto> listSuggestDoctor(DoctorReq doctorReq);

    //疾病搜索医生
    Page<DoctorInfoDto> doctorSearchByDisease(DoctorReq doctorReq);

    int deleteByPrimaryKey(String doctId);

    int insert(DoctorInfo record);

    int insertSelective(DoctorInfo record);

    DoctorInfo selectByPrimaryKey(String doctId);

    int updateByPrimaryKeySelective(DoctorInfo record);

    int updateByPrimaryKey(DoctorInfo record);
}