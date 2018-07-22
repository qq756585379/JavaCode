package com.vo;

import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.User;
import lombok.Data;

import java.util.List;

@Data
public class OrderVO extends Order {

    //用户信息
    private User user;

    //订单明细信息
    private List<OrderItemVO> orderItemVOList;

}
