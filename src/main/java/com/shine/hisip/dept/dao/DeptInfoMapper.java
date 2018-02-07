package com.shine.hisip.dept.dao;


import com.github.pagehelper.Page;
import com.shine.hisip.dept.dto.DeptDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptInfoMapper {
    Page<DeptDto> parentList(DeptDto deptDto);
    Page<DeptDto> childList(DeptDto deptDto);
}