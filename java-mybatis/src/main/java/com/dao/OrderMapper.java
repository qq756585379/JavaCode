package com.dao;

import com.pojo.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> findOrdersAndOrderDetailResultMap();

}
