package com.dao;

import com.pojo.StudentMajor;

import java.util.List;

public interface StudentMajorMapper {

    /**
     * 全表查询
     */
    public List<StudentMajor> selectAll();

    /**
     * 根据主键查数据,给多对一用
     */
    public StudentMajor select(Integer id);

}
