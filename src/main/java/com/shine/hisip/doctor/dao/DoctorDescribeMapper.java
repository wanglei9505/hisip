package com.shine.hisip.doctor.dao;

import com.shine.hisip.common.domain.DoctorDescribe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoctorDescribeMapper {
    int deleteByPrimaryKey(String id);

    int insert(DoctorDescribe record);

    int insertSelective(DoctorDescribe record);

    DoctorDescribe selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DoctorDescribe record);

    int updateByPrimaryKeyWithBLOBs(DoctorDescribe record);

    int updateByPrimaryKey(DoctorDescribe record);
}