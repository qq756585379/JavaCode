package com.dao;

import com.BaseTest;
import com.pojo.Order;
import com.pojo.Student;
import com.pojo.StudentMajor;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DaoTest extends BaseTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentMajorMapper studentMajorMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testDao() {
        List<StudentMajor> list = studentMajorMapper.selectAll();

//        List<Student> list = studentMapper.selectall();

//        List<Order> list = orderMapper.findOrdersAndOrderDetailResultMap();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
