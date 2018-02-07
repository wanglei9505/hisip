package com.shine.hisip.dict.dao;

import com.shine.hisip.common.domain.PublicDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PublicDictMapper {
    List<PublicDict> getListByType(String name);

    int deleteByPrimaryKey(String id);

    int insert(PublicDict record);

    int insertSelective(PublicDict record);

    PublicDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PublicDict record);

    int updateByPrimaryKey(PublicDict record);
}