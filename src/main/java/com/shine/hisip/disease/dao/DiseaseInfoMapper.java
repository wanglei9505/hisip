package com.shine.hisip.disease.dao;

import com.github.pagehelper.Page;
import com.shine.hisip.common.domain.DiseaseInfo;
import com.shine.hisip.disease.dto.DiseaseDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiseaseInfoMapper {

    Page<DiseaseDto> getByType(DiseaseDto diseaseDto);

    int deleteByPrimaryKey(String id);

    int insert(DiseaseInfo record);

    int insertSelective(DiseaseInfo record);

    DiseaseInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DiseaseInfo record);

    int updateByPrimaryKey(DiseaseInfo record);
}