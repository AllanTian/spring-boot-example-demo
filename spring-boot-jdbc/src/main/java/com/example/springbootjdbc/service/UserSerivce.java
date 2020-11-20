package com.example.springbootjdbc.service;


import com.example.springbootjdbc.bean.User;

import java.util.List;

/**
 * @ClassName: UserSerivce
 * @Description: (描述)
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/11/19 下午10:07
 */
public interface UserSerivce {


    /**
     * 查询数据
     */
    List<User> getUserList();


    /**
     * 写入数据
     */
    int insertUser(User user);


    /**
     * 条件查询
     */
    User getUser(Integer id);

    /**
     * 更新数据
     */
    int updateUser(User user);


    /**
     * 删除数据
     */
    int deleteUser(Integer id);


}
