package com.example.springbootjdbc.service.impl;


import com.example.springbootjdbc.bean.User;
import com.example.springbootjdbc.dao.UserDao;
import com.example.springbootjdbc.service.UserSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: (描述)
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/11/19 下午10:12
 */

@Service
public class UserServiceImpl implements UserSerivce {


    @Resource
    private UserDao userDao;


    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }
}
