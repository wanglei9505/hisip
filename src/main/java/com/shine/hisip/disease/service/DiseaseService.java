package com.shine.hisip.disease.service;

import com.github.pagehelper.Page;
import com.shine.hisip.disease.dto.DiseaseDto;

/**
 * @Author: a
 * @DATE: Created in 2018/2/5
 **/
public interface DiseaseService {
    /**
     * 按类型获取
     * @param
     * @return
     */
    Page<DiseaseDto> getByType(DiseaseDto diseaseDto);
}
