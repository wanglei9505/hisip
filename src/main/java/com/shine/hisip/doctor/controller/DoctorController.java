package com.shine.hisip.doctor.controller;

import com.github.pagehelper.Page;
import com.shine.hisip.common.BaseController;
import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.common.response.enumeration.ResponseStatus;
import com.shine.hisip.doctor.dto.DoctorInfoDto;
import com.shine.hisip.doctor.dto.DoctorReq;
import com.shine.hisip.doctor.service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: a
 * @DATE: Created in 2018/1/26
 **/
@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController {
    @Autowired
    private DoctorInfoService doctorService;

    /**
     * 根据部门获取医生排班
     * @param req
     * @return
     */
    @RequestMapping(value = "/dept",method = RequestMethod.GET)
    public ResponseCom doctorByDept(DoctorReq req){
        ResponseCom<DoctorInfoDto> res=ResponseCom.newInstance();
        if (req.getDeptId() == null){
            res.setResultCode(ResponseStatus.OPRERATE_FAILED.getCode());
            res.setResultInfo(ResponseStatus.OPRERATE_FAILED.getNote());
            return res;
        }
        Page<DoctorInfoDto> page=doctorService.listDoctorByDept(req);
        res.getPage().setTotal(page.getTotal());
        res.getPage().setRows(page.getResult());
        return res;
    }

    /**
     * 根据预约日期
     * @param req
     * @return
     */
    @RequestMapping(value = "/date",method = RequestMethod.GET)
    public ResponseCom doctorByDate(DoctorReq req){
        ResponseCom<DoctorInfoDto> res=ResponseCom.newInstance();
        Page<DoctorInfoDto> page=doctorService.listDoctorByDate(req);
        res.getPage().setTotal(page.getTotal());
        res.getPage().setRows(page.getResult());
        return res;
    }

    /**
     * 获取医生详情信息
     * @param req
     * @return
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResponseCom doctorById(DoctorReq req){
        ResponseCom<DoctorInfoDto> res=ResponseCom.newInstance();
        DoctorInfoDto doctor=doctorService.getDoctorDetial(req);
        res.setObj(doctor);
        return res;
    }

    /**
     * 医生查找-姓名
     * @param req
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseCom doctorSearch(DoctorReq req){
        ResponseCom<DoctorInfoDto> res=ResponseCom.newInstance();
        Page<DoctorInfoDto> page=null;
        if (req.getDiseaseName() != null){
            page=doctorService.doctorSearchByDisease(req);
        }else{
            page=doctorService.doctorSearch(req);
        }
        res.getPage().setTotal(page.getTotal());
        res.getPage().setRows(page.getResult());
        return res;
    }

    /**
     * 推荐医生
     * @param req
     * @return
     */
    @RequestMapping(value = "/suggest",method = RequestMethod.GET)
    public ResponseCom suggest(DoctorReq req){
        ResponseCom<DoctorInfoDto> res=ResponseCom.newInstance();
        Page<DoctorInfoDto> page=doctorService.listSuggestDoctor(req);
        res.getPage().setTotal(page.getTotal());
        res.getPage().setRows(page.getResult());
        return res;
    }
    /**
     * 医生查找-疾病
     * @param req
     * @return
     */
    @RequestMapping(value = "/searchByDisease",method = RequestMethod.GET)
    public ResponseCom doctorSearchByDisease(DoctorReq req){
        ResponseCom<DoctorInfoDto> res=ResponseCom.newInstance();
        Page<DoctorInfoDto> page=doctorService.doctorSearchByDisease(req);
        res.getPage().setTotal(page.getTotal());
        res.getPage().setRows(page.getResult());
        return res;
    }

}
