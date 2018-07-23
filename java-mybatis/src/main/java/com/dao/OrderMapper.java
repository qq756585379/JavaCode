package com.dao;

import com.pojo.Order;
import com.vo.OrderVO;
import com.vo.UserVO;

import java.util.List;

public interface OrderMapper {

    List<OrderVO> findOrderVOList();

    List<OrderVO> findOrdersAndUser();

    List<Order> findOrders();

    OrderVO findOrderByOrderNo(Long orderNo);

    Order findOrderVO();

    // OrderVO findOrderVO();
    //
    // List<OrderVO> findOrderVOs();
    //
    // List<UserVO> findUserVOs();
}
