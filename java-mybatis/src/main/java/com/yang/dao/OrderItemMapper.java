package com.yang.dao;

import com.yang.pojo.OrderItem;
import com.yang.vo.OrderItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper {

    OrderItem selectByPrimaryKey(Integer id);

    List<OrderItemVO> getOrderItemVOListsByOrderNo(@Param("orderNo") Long orderNo);

    List<OrderItem> getOrderItemListsByOrderNo(@Param("orderNo") Long orderNo);

    int insertSelective(OrderItem record);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}
