package com.java4all.serviceImpl;

import com.java4all.dao.UserDao;
import com.java4all.entity.User;
import com.java4all.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        String sql = "SELECT COUNT(*) FROM user";
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
        //错误写法，如果打印出此sql，会发现?还是?，并没有被参数替换掉
        String sql = "select * from user where 1= 1 and province = ? and city = ?";

        String sql2 = "select * from user where 1= 1 and province ='"+ province +"' and city ='"+city + "'";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql2);

        List<User> listRe = new ArrayList<>();
        for(int i = 0 , length = list.size();i < length; i ++){
            Map<String, Object> map = list.get(i);
            User user = new User();
            //这个map转为实体的方式，可以抽取出来，其他方法可复用
            user.setId((int)map.get("id"));
            user.setUserName((String)map.get("user_name"));
            user.setRealName((String)map.get("real_name"));
            user.setPassword((String)map.get("password"));
            user.setCountry((String)map.get("country"));
            user.setProvince((String)map.get("province"));
            user.setCity((String)map.get("city"));
            user.setPhone((String)map.get("phone"));
            user.setCreateTime((Date) map.get("create_time"));
            user.setDevLanguage((String)map.get("dev_language"));
            user.setSchoolName((String)map.get("school_name"));
            user.setSchoolMajor((String)map.get("school_major"));
            listRe.add(user);
        }
        return listRe;
    }
}
