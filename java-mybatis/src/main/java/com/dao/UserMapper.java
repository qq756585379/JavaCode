package com.dao;

import com.pojo.User;
import com.vo.UserVO;

import java.util.List;

public interface UserMapper {

    User findUserById(int id) throws Exception;

    //综合查询
    List<User> findUserList(UserVO vo);

}
