package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 全表查询
     */
    public List<Student> selectall();

    /**
     * 根据专业查人员,给一对多用
     */
    public List<Student> selectz(Integer major);

}
