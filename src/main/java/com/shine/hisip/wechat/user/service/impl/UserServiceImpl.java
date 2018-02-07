package com.shine.hisip.wechat.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shine.hisip.utils.WeiHttpsUtils;
import com.shine.hisip.wechat.user.dto.WeChatUserInfo;
import com.shine.hisip.wechat.user.dao.WeChatUserMapper;
import com.shine.hisip.wechat.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: a
 * @DATE: Created in 2018/1/19
 **/
@Service
public class UserServiceImpl implements UserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private WeChatUserMapper userDao;
    @Override
    public WeChatUserInfo save(String accessToken, String openId) {
        WeChatUserInfo userInfo=getUserInfo(accessToken,openId);
        WeChatUserInfo existUser=userDao.selectByOpenId(userInfo);
        if (existUser == null) {
            userDao.save(userInfo);
        }else {
            userDao.update(userInfo);
        }
        return userInfo;
    }



    /**
     * 获取用户信息
     *
     * @param accessToken 接口访问凭证
     * @param openId 用户标识
     * @return WeChatUserInfo
     */
    public static WeChatUserInfo getUserInfo(String accessToken, String openId) {
        WeChatUserInfo weixinUserInfo = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 获取用户信息
        JSONObject jsonObject = WeiHttpsUtils.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
//                weixinUserInfo=JSONObject.toJavaObject(jsonObject,WeChatUserInfo.class);

                weixinUserInfo = new WeChatUserInfo();
                // 用户的标识
                weixinUserInfo.setOpenId(jsonObject.getString("openid"));
                // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
                weixinUserInfo.setSubscribe(jsonObject.getIntValue("subscribe"));
                // 用户关注时间
                weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
                // 昵称
                weixinUserInfo.setNickName(jsonObject.getString("nickname"));
                // 用户的性别（1是男性，2是女性，0是未知）
                weixinUserInfo.setSex(jsonObject.getIntValue("sex"));
                // 用户所在国家
                weixinUserInfo.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                weixinUserInfo.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                weixinUserInfo.setCity(jsonObject.getString("city"));
                // 用户的语言，简体中文为zh_CN
                weixinUserInfo.setLanguage(jsonObject.getString("language"));
                // 用户头像
                weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
            } catch (Exception e) {
                if (0 == weixinUserInfo.getSubscribe()) {
                    log.error("用户{}已取消关注", weixinUserInfo.getOpenId());
                } else {
                    int errorCode = jsonObject.getIntValue("errcode");
                    String errorMsg = jsonObject.getString("errmsg");
                    log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
                }
            }
        }
        return weixinUserInfo;
    }
}
