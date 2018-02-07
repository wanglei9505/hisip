package com.shine.hisip.wechat.user.dao;

import com.shine.hisip.wechat.user.dto.WeChatUserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: a
 * @DATE: Created in 2018/1/19
 **/
@Mapper
public interface WeChatUserMapper {
    int save(WeChatUserInfo userInfo);
    int update(WeChatUserInfo userInfo);
    WeChatUserInfo selectByOpenId(WeChatUserInfo userInfo);
}
