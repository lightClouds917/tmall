package com.java4all.serviceImpl;

import com.java4all.dao.UserDao;
import com.java4all.entity.User;
import com.java4all.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: momo
 * Date: 2018/3/29
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getById(Integer id) {
        User user = userDao.getById(id);
        return user;
    }

    /**       JdbcTemplate      */
    @Override
    public Integer getCount() {
        String sql = "SELECT COUNT (*) FROM user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public void deleteUserById(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateUserById(String userName,Integer id) {
        String sql = "update user set user_name = ? where id = ?";
        jdbcTemplate.update(sql,userName,id);
    }

    @Override
    public List<User> getUserByProvinceAndCity(String province, String city) {
        String sql = "select * from user where 1= 1 and province = ? and city = ?";

        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.findColumn("id"));
                user.setUserName(resultSet.getNString("user_name"));
                return user;
            }
        }, province, city);

        return list;
    }
}
