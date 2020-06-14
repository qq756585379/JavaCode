package com.mall.portal.dao;

import com.mall.portal.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long pid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long pid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}