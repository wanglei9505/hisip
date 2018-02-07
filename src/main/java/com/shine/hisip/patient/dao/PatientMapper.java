package com.shine.hisip.patient.dao;

import com.github.pagehelper.Page;
import com.shine.hisip.patient.dto.PatientDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: a
 * @DATE: Created in 2018/1/22
 **/
@Mapper
public interface PatientMapper {

    int add(PatientDto patient);

    int edit(PatientDto patient);

    int delete(PatientDto patient);

    Page<PatientDto> getPatientsByUser(PatientDto patient);

    PatientDto getCardByPatient(PatientDto patient);

    PatientDto getDefultPatient(PatientDto patient);

}
