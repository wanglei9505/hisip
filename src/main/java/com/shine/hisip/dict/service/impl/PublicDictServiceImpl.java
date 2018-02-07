package com.shine.hisip.dict.service.impl;

import com.shine.hisip.common.domain.PublicDict;
import com.shine.hisip.dict.dao.PublicDictMapper;
import com.shine.hisip.dict.service.PublicDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: a
 * @DATE: Created in 2018/1/23
 **/
@Service
public class PublicDictServiceImpl implements PublicDictService {
    @Autowired
    private PublicDictMapper dictMapper;
    @Override
    public List<PublicDict> getListByType(String type) {
        return dictMapper.getListByType(type);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return dictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PublicDict record) {
        return dictMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(PublicDict record) {
        return dictMapper.updateByPrimaryKeySelective(record);
    }
}
