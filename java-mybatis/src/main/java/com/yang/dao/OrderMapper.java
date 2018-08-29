package com.yang.dao;

import com.yang.pojo.Order;
import com.yang.vo.OrderVO;
import com.yang.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<OrderVO> findOrderVOList();

    List<OrderVO> findOrderVOList2();

    OrderVO findOrderVOByOrderNo(Long orderNo);

    Order selectByOrderNo(Long orderNo);

}
