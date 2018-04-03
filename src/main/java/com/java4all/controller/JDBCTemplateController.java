package com.java4all.controller;

import com.java4all.entity.User;
import com.java4all.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: momo
 * Date: 2018/4/3
 * Description:演示JDBCTemplate
 */
@RestController
@RequestMapping("jdbcUser")
public class JDBCTemplateController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getCount",method = RequestMethod.GET)
    public Integer getCount(){
        Integer count = userService.getCount();
        return count;
    }

    @RequestMapping(value = "deleteUserById",method = RequestMethod.GET)
    public void  deleteUserById(Integer id){
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "updateUserById",method = RequestMethod.GET)
    public void  updateUserById(String userName,Integer id){
        userService.updateUserById(userName,id);
    }

    @RequestMapping(value = "getUserByProvinceAndCity",method = RequestMethod.GET)
    public List<User>  getUserByProvinceAndCity(String province,String city){
        List<User> list = userService.getUserByProvinceAndCity(province, city);
        return list;
    }

}
