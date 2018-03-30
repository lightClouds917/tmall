package com.java4all.serviceImpl;

import com.java4all.dao.UserDao;
import com.java4all.entity.User;
import com.java4all.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: momo
 * Date: 2018/3/29
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Integer id) {
        User user = userDao.getById(id);
        return user;
    }
}
