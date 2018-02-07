package com.shine.hisip.disease.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shine.hisip.disease.dao.DiseaseInfoMapper;
import com.shine.hisip.disease.dto.DiseaseDto;
import com.shine.hisip.disease.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: a
 * @DATE: Created in 2018/2/5
 **/
@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    private DiseaseInfoMapper diseaseMapper;

    @Override
    public Page<DiseaseDto> getByType(DiseaseDto diseaseDto) {
        PageHelper.startPage(1,10);
        return diseaseMapper.getByType(diseaseDto);
    }
}
