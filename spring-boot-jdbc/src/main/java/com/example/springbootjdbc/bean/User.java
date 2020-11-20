package com.example.springbootjdbc.bean;


import lombok.Data;

/**
 * @ClassName: User
 * @Description: (描述)
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/11/19 下午8:52
 */

@Data
public class User {
    /**
     * ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

}
