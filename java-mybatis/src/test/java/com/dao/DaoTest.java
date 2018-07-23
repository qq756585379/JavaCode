package com.dao;

import com.BaseTest;
import com.pojo.Order;
import com.pojo.Student;
import com.pojo.StudentMajor;
import com.pojo.User;
import com.vo.OrderVO;
import com.vo.UserVO;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DaoTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentMajorMapper studentMajorMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testDao() {
        // List<StudentMajor> list = studentMajorMapper.selectAll();

//        List<Student> list = studentMapper.selectall();

//        List<Order> list = orderMapper.findOrdersAndOrderDetailResultMap();
//         for (int i = 0; i < list.size(); i++) {
//             System.out.println(list.get(i));
//         }
    }

    @Test
    public void findUserById() {
        try {
            User user = userMapper.findUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findOrders() {
        try {
            List<Order> orders = orderMapper.findOrders();
            System.out.println(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findOrderByOrderNo() {
        try {
            OrderVO order = orderMapper.findOrderByOrderNo(1491753014256L);
            System.out.println(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findOrderVO() {
        try {
            Order orderVO = orderMapper.findOrderVO();
            System.out.println(orderVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findOrderVOList() {
        try {
            List<OrderVO> orderVOList = orderMapper.findOrderVOList();
            System.out.println(orderVOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @Test
    // public void testOrderListDao() {
    //     try {
    //         List<OrderVO> orderVOList = orderMapper.findOrderVOs();
    //         System.out.println(orderVOList);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
    //
    // @Test
    // public void testUserVoDao() {
    //     try {
    //         List<UserVO> userVOS = orderMapper.findUserVOs();
    //         System.out.println(userVOS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    @Test
    public void findOrdersAndUser() {
        try {
            List<OrderVO> orderVOList = orderMapper.findOrdersAndUser();
            System.out.println(orderVOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
