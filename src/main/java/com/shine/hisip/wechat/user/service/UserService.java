package com.shine.hisip.wechat.user.service;


import com.shine.hisip.wechat.user.dto.WeChatUserInfo;

/**
 * @Author: a
 * @DATE: Created in 2018/1/19
 **/
public interface UserService {
    WeChatUserInfo save(String accessToken, String openId);
//    WeChatUserInfo selectByOpenId(String openId);
}
