package com.shine.hisip.dept.controller;

import com.github.pagehelper.Page;
import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.dept.dto.DeptDto;
import com.shine.hisip.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: a
 * @DATE: Created in 2018/1/24
 **/
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/parent",method = RequestMethod.GET)
    public ResponseCom parent(DeptDto deptDto){
        ResponseCom res=ResponseCom.newInstance();
        Page<DeptDto> page=deptService.parentList(deptDto);
        res.getPage().setRows(page.getResult());
        res.getPage().setTotal(page.getTotal());
        return res;
    }
    @RequestMapping(value = "/children",method = RequestMethod.GET)
    public ResponseCom child(DeptDto deptDto){
        ResponseCom res=ResponseCom.newInstance();
        Page<DeptDto> page=deptService.childList(deptDto);
        res.getPage().setRows(page.getResult());
        res.getPage().setTotal(page.getTotal());
        return res;
    }
}
