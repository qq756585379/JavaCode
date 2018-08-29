package com.yang.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderItem {

    private Integer id;

    private Integer userId;

    private Long orderNo;

    private Integer productId;

    private String productName;

    private String productImage;

    //生成订单时的商品单价
    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Date createTime;

    private Date updateTime;

}