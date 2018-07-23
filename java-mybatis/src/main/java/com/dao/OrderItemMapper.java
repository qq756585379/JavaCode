package com.dao;

import com.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {

    OrderItem selectByPrimaryKey(Integer id);

    List<OrderItem> getByOrderNo(@Param("orderNo") Long orderNo);


    // int insert(Items record);
    //
    // int deleteByPrimaryKey(Integer id);
    //
    // int insertSelective(Items record);
    //
    // int updateByPrimaryKeySelective(Items record);
    //
    // int updateByPrimaryKeyWithBLOBs(Items record);
    //
    // int updateByPrimaryKey(Items record);
}
