package com.yang.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 一个用户拥有多个订单
 * 一个订单里有多个订单明细
 * 一个对单明细对应一个商品
 */
@Data
public class User {

    private int id;
    private String username;// 用户姓名
    private String birthday;// 生日
    private String sex;// 性别
    private String address;// 地址

    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private Date createTime;

    private Date updateTime;
}
