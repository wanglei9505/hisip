package com.shine.hisip.patient.service;

import com.github.pagehelper.Page;
import com.shine.hisip.patient.dto.PatientDto;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/22
 **/
public interface PatientService {
    int add(PatientDto patient);

    int edit(PatientDto patient);

    int delete(PatientDto patient);

    /**
     * 获取用户下的所有就诊人
     * @param patient
     * @return
     */
    Page<PatientDto> getPatientsByUser(PatientDto patient);
//    List<PatientDto> getPatientsByUser(PatientDto patient);

    /**
     * 获取默认就诊人
     * @param patient
     * @return
     */
    PatientDto getDefault(PatientDto patient);

    /**
     * 根据就诊人获取就诊卡信息
     * @param patient
     * @return
     */
    PatientDto getCardByPatient(PatientDto patient);
}
