package com.yang.dao;

import com.yang.pojo.User;
import com.yang.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User findUserById(int id) throws Exception;

    //综合查询
    List<User> findUserList(UserVO vo);

    List<UserVO> findUserAndItemsRst();

}
