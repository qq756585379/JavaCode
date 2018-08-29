package com.test.dao;

import com.test.BaseTest;
import com.yang.dao.UserMapper;
import com.yang.pojo.User;
import com.yang.vo.UserVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUserById() {
        try {
            User user = userMapper.findUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findUserVOs() {
        try {
            List<UserVO> list = userMapper.findUserAndItemsRst();
            for (UserVO vo : list) {
                System.out.println("===============" + vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
