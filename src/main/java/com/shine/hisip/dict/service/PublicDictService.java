package com.shine.hisip.dict.service;

import com.shine.hisip.common.domain.PublicDict;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/23
 **/
public interface PublicDictService {
    /**
     * 根据字典名称获取列表
     * @param type
     * @return
     */
    List<PublicDict> getListByType(String type);
    int deleteByPrimaryKey(String id);
    int insertSelective(PublicDict record);
    int updateByPrimaryKeySelective(PublicDict record);
}
