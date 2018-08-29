package com.yang.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserVO {

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

    private List<OrderVO> orderVOS;

}
