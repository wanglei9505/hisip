package com.shine.hisip.dept.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shine.hisip.dept.dao.DeptInfoMapper;
import com.shine.hisip.dept.dto.DeptDto;
import com.shine.hisip.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: a
 * @DATE: Created in 2018/1/24
 **/
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptInfoMapper deptMapper;
    //todo 根据需求修改部门列表展示
    @Override
    public Page<DeptDto> parentList(DeptDto deptDto) {
        PageHelper.startPage(deptDto.getCurrentPage(),deptDto.getPageSize());
        return deptMapper.parentList(deptDto);
    }

    @Override
    public Page<DeptDto> childList(DeptDto deptDto) {
        PageHelper.startPage(deptDto.getCurrentPage(),deptDto.getPageSize());
        return deptMapper.childList(deptDto);
    }
}
