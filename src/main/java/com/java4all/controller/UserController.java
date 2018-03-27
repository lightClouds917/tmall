package com.java4all.controller;

import com.java4all.dao.UserRepository;
import com.java4all.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: momo
 * Date: 2018/3/26
 * Description:
 */

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "getListByProvince",method = RequestMethod.GET)
    public User getListByProvince(){
        User user = userRepository.findById(599986);
        userRepository.deleteById(599988);
        userRepository.deleteById(599989);
        return user;
    }

}
