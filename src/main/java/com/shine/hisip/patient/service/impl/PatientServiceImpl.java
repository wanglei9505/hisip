package com.shine.hisip.patient.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shine.hisip.patient.dao.PatientMapper;
import com.shine.hisip.patient.dto.PatientDto;
import com.shine.hisip.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/22
 **/
@Service
@Transactional(rollbackFor=Exception.class)
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;
    @Override
    public int add(PatientDto patient) {
        PatientDto patientDto=changDefultPatient(patient);
        return patientMapper.add(patientDto);
    }

    @Override
    public int edit(PatientDto patient) {
        PatientDto patientDto=changDefultPatient(patient);
        return patientMapper.edit(patientDto);
    }

    @Override
    public int delete(PatientDto patient) {
        return patientMapper.delete(patient);
    }

    @Override
    public Page<PatientDto> getPatientsByUser(PatientDto patient) {
        PageHelper.startPage(1,100);
        return patientMapper.getPatientsByUser(patient);
    }

    @Override
    public PatientDto getDefault(PatientDto patient) {
        return patientMapper.getDefultPatient(patient);
    }

    @Override
    public PatientDto getCardByPatient(PatientDto patient) {
        return patientMapper.getCardByPatient(patient);
    }

    /**
     * 更改默认就诊人
     * @param patient
     */
    private PatientDto changDefultPatient(PatientDto patient){
        if (patient != null && patient.getIsDefault() != null) {
            //获取默认就诊人
            PatientDto defult = patientMapper.getDefultPatient(patient);
            if (defult == null) {
                if (patient.getIsDefault() == 0) {
                    patient.setIsDefault(Short.valueOf("1"));
                }
            } else {
                if (patient.getIsDefault() == 1) {
                    defult.setIsDefault(Short.valueOf("0"));
                    patientMapper.edit(defult);
                }else {
                    if (defult.getId().equals(patient.getId())){
                        throw new RuntimeException("默认就诊人，不可删除");
                    }
                }
            }
        }
        return patient;
    }
}
