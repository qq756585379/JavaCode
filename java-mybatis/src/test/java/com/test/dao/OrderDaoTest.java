package com.test.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.BaseTest;
import com.yang.dao.OrderMapper;
import com.yang.pojo.Order;
import com.yang.vo.OrderVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDaoTest extends BaseTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void findOrderByOrderNo() {
        try {
            OrderVO order = orderMapper.findOrderVOByOrderNo(1491753014256L);
            System.out.println(JSONObject.toJSON(order));
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

    @Test
    public void findOrderVOList2() {
        try {
            List<OrderVO> orderVOList = orderMapper.findOrderVOList2();
            for (OrderVO vo : orderVOList) {
                System.out.println("===============" + vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
