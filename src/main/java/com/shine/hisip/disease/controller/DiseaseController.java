package com.shine.hisip.disease.controller;

import com.github.pagehelper.Page;
import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.disease.dto.DiseaseDto;
import com.shine.hisip.disease.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: a
 * @DATE: Created in 2018/2/5
 **/
@RestController
@RequestMapping("/disease")
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseCom parent(DiseaseDto diseaseDto){
        ResponseCom res=ResponseCom.newInstance();
        Page<DiseaseDto> page=diseaseService.getByType(diseaseDto);
        res.getPage().setRows(page.getResult());
        res.getPage().setTotal(page.getTotal());
        return res;
    }
}
