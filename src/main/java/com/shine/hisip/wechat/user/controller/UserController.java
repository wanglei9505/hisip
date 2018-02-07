package com.shine.hisip.wechat.user.controller;


import com.shine.hisip.common.BaseController;
import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.utils.TokenManager;
import com.shine.hisip.wechat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: a
 * @DATE: Created in 2018/1/19
 **/
@RestController
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private TokenManager tokenManager;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResponseCom access(String openId){
        String accessToken=tokenManager.getTokenString();
        ResponseCom res=ResponseCom.newInstance();
        userService.save(accessToken,openId);
        return res;
    }
   /* @RequestMapping("/index")
    public String index(){
        return "index";
    }*/
}
