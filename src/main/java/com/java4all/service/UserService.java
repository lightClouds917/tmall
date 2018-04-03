package com.java4all.service;

import com.java4all.entity.User;

import java.util.List;

/**
 * Author: momo
 * Date: 2018/3/29
 * Description:
 */
public interface UserService {

    User getById(Integer id);

    Integer getCount();

    void deleteUserById(Integer id);

    void updateUserById(String userName,Integer id);

    List<User> getUserByProvinceAndCity(String province, String city);
}
