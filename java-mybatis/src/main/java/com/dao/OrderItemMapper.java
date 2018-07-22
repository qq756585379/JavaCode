package com.dao;

import com.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {

    List<OrderItem> getByOrderNo(@Param("orderNo") Long orderNo);

}
