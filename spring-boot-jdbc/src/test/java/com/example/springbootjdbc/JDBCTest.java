package com.example.springbootjdbc;

import com.example.springbootjdbc.bean.User;
import com.example.springbootjdbc.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @ClassName: JDBCTest
 * @Description: (描述)
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/11/19 下午11:06
 */
@Slf4j
@Component
public class JDBCTest extends SpringBootJdbcApplicationTests {

    @Autowired
    private UserSerivce userSerivce;

    /**
     * 新增数据
     */

    @Test
    public void save() {

        User user = new User();
        user.setUsername("张三");
        user.setPassword("zhangsan");
        user.setSex(0);
        user.setAge(30);

        int row = userSerivce.insertUser(user);
        //判断结果
        if (row == -1) {
            System.out.println("新增失败");
        } else {
            System.out.println("新增成功");

        }
    }

    /**
     * 查询数据
     */
    @Test
    public void query() {
        //查寻数据
        List<User> userList = userSerivce.getUserList();

        //返回数据
        System.out.println(userList.toString());
    }


    /**
     * 更新数据
     */
    @Test
    public void update() {
        //新建对象传递数据
        User user = new User();
        user.setId(1);
        user.setUsername("修改");
        user.setPassword("123");
        user.setSex(1);
        user.setAge(10);
        //执行更新操作
        int row = userSerivce.updateUser(user);
        //判断结果
        if (row == -1) {
            System.out.println("新增失败");
        } else {
            System.out.println("新增成功");

        }
    }

    /**
     * 删除数据
     */
    @Test
    public void delete() {
        //初始化数据
        Integer id = 1;
        //执行删除
        int row = userSerivce.deleteUser(id);
        //判断结果
        if (row == -1) {
            System.out.println("新增失败");
        } else {
            System.out.println("新增成功");

        }
    }

}

