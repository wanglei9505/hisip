package com.shine.hisip.dept.service;

import com.github.pagehelper.Page;
import com.shine.hisip.dept.dto.DeptDto;

/**
 * @Author: a
 * @DATE: Created in 2018/1/24
 **/
public interface DeptService {
    /**
     * 一级科室列表
     * @param deptDto
     * @return
     */
    Page<DeptDto> parentList(DeptDto deptDto);

    /**
     * 二级科室列表
     * @param deptDto
     * @return
     */
    Page<DeptDto> childList(DeptDto deptDto);
}
