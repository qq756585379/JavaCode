package com.dao;

import com.pojo.Order;
import com.vo.OrderVO;

import java.util.List;

public interface OrderMapper {

    List<OrderVO> findOrderVOs();

}
