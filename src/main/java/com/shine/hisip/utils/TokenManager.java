package com.shine.hisip.utils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.shine.hisip.common.Constants;
import com.shine.hisip.common.domain.Token;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


import java.util.concurrent.TimeUnit;

import static com.shine.hisip.utils.WeiHttpsUtils.httpsRequest;

/**
 * @Author: a
 * @DATE: Created in 2018/2/6
 **/
@Component
public class TokenManager {
    private static Logger log = LoggerFactory.getLogger(TokenManager.class);
    // 获取access_token的接口地址（GET） 限2000（次/天）
    public final static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    @Value("${com.shine.appid}")
    private String appid;
    @Value("${com.shine.appsecret}")
    private String appsecret;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*public TokenManager(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }*/

    public String getTokenString(){
       String token=null;
       token = stringRedisTemplate.opsForValue().get(Constants.WX_TOKEN);
       if (token == null) {
           if (StringUtils.isEmpty(token)) {
               Token tokens = getToken(appid, appsecret);
               stringRedisTemplate.opsForValue().set(Constants.WX_TOKEN, tokens.getAccessToken(),Constants.EXP_TIMES, TimeUnit.SECONDS);
               return tokens.getAccessToken();
           }
       }
       return token;
    }

    /**
     * 获取接口访问凭证
     *
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public static Token getToken(String appid, String appsecret) {
        Token token = null;
        String requestUrl = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        // 发起GET请求获取凭证
        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                token = new Token();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getIntValue("expires_in"));
            } catch (JSONException e) {
                token = null;
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return token;
    }


}
