package com.yang.dao;

import com.yang.pojo.StudentMajor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
