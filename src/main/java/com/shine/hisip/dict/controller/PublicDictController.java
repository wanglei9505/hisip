package com.shine.hisip.dict.controller;

import com.shine.hisip.common.BaseController;
import com.shine.hisip.common.domain.PublicDict;
import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.dict.service.PublicDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/23
 **/
@RestController
@RequestMapping("/dict")
public class PublicDictController extends BaseController {
    @Autowired
    private PublicDictService dictService;

    /**
     * 返回值列表
     * @param type
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseCom listByName(String type){
        String param=type.toUpperCase();
        ResponseCom res=ResponseCom.newInstance();
        List<PublicDict> list=dictService.getListByType(param);
        res.setList(list);
        return res;
    }
}
