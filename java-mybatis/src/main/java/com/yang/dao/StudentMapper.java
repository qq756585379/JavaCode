package com.yang.dao;

import com.yang.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
