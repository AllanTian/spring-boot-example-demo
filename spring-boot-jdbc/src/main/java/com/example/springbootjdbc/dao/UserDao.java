package com.example.springbootjdbc.dao;


import com.example.springbootjdbc.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: (描述)
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/11/19 下午9:38
 */

@Repository
public class UserDao {

    /**
     * SpringBoot提供的数据库操作类
     */
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * JDBC 查询数据
     *
     * @return List<User>
     */
    public List<User> getUserList() {

        //SQL
        String sql = "SELECT  *  FROM user ";

        //返回结果
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
    }


    /**
     * JDBC 写入数据
     *
     * @param user User
     */
    public int insertUser(User user) {

        //SQL
        String sql = " INSERT INTO user (username , password , sex , age ) values(?,?,?,?)";

        //执行写入
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getAge());
    }


    /**
     * 根据 条件查询数据
     *
     * @param id id
     * @return User
     */
    public User getUser(Integer id) {
        final User user = new User();

        //SQL
        String sql = "SELECT *  FROM user WHERE id = " + id;

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            //映射每行数据
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setId(id);
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getInt("sex"));
                user.setAge(rs.getInt("age"));
            }
        });
        return user;
    }

    /**
     * JDBC 更新数据
     *
     * @param user
     * @return int
     */
    public int updateUser(User user) {

        //SQL
        String sql = "UPDATE user SET username = ? , password = ? , sex = ? , age = ?  where id = ?";

        //返回结果
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getAge(), user.getId());
    }

    /**
     * JDBC 删除数据
     *
     * @param id id
     */

    public int deleteUser(Integer id) {

        //SQL
        String sql = "DELETE FROM user WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }

}