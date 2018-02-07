package com.shine.hisip.patient.controller;

import com.github.pagehelper.Page;
import com.shine.hisip.common.BaseController;
import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.patient.dto.PatientDto;
import com.shine.hisip.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/22
 **/
@RestController
@RequestMapping("/patient")
public class PatientController extends BaseController {
    @Autowired
    private PatientService patientService;

    /**
     * 保存或修改就诊人
     * @param patientDto
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseCom save(@RequestBody PatientDto patientDto){
        ResponseCom res=ResponseCom.newInstance();
        if (patientDto.getId() != null) {
            patientDto.setUpdateTime(new Date());
            patientService.edit(patientDto);
        }else {
            patientDto.setCreateTime(new Date());
            patientService.add(patientDto);
        }
        return res;
    }

    /**
     * 删除就诊人
     * @param patientDto
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseCom delete(@RequestBody PatientDto patientDto){
        ResponseCom res=ResponseCom.newInstance();
        patientService.delete(patientDto);
        return res;
    }

    /**
     * 就诊人列表
     * @param patientDto
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseCom page(PatientDto patientDto){
        ResponseCom res=ResponseCom.newInstance();
        Page<PatientDto> patients=patientService.getPatientsByUser(patientDto);
        res.getPage().setRows(patients.getResult());
        res.getPage().setTotal(patients.getTotal());
        return res;
    }

    /**
     * 获取就诊卡信息
     * @param patientDto
     * @return
     */
    @RequestMapping(value = "/card",method = RequestMethod.GET)
    public ResponseCom getCardInfo(PatientDto patientDto){
        ResponseCom res=ResponseCom.newInstance();
        PatientDto card=patientService.getCardByPatient(patientDto);
        res.setObj(card);
        return res;
    }

    /**
     * 获取默认就诊人
     * @param patientDto
     * @return
     */
    @RequestMapping(value = "/default",method = RequestMethod.GET)
    public ResponseCom getDefault(PatientDto patientDto){
        ResponseCom res=ResponseCom.newInstance();
        PatientDto patient=patientService.getDefault(patientDto);
        res.setObj(patient);
        return res;
    }

}
