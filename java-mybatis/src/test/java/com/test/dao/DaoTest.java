package com.test.dao;

import com.yang.dao.UserMapper;
import com.yang.pojo.Order;
import com.yang.pojo.User;
import com.yang.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class DaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        // 创建UserDao
        UserMapper impl = (UserMapper) applicationContext.getBean("userMapper");
        User user = impl.findUserById(1);
        System.out.println(user);
    }
}
