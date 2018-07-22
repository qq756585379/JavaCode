package com.vo;

import com.pojo.User;
import lombok.Data;

import java.util.List;

@Data
public class UserVO extends User {

    private List<OrderVO> orderVOS;

}
