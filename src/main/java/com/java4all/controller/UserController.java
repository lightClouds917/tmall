package com.java4all.controller;

import com.java4all.dao.UserRepository;
import com.java4all.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: momo
 * Date: 2018/3/26
 * Description:
 */

@RestController
@RequestMapping("user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger("");

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询操作
     * @return
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public User getList(){
        User user = userRepository.findById(599986);
        userRepository.deleteById(599988);

        return user;
    }

    /**
     * 增删改等操作
     * @return
     */
    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    public String addUser(){

        User user = new User();
        user.setUserName("momo");
        user.setCountry("中国啊");
        userRepository.saveAndFlush(user);

        return "操作成功";
    }

    @RequestMapping(value = "findByPage",method = RequestMethod.GET)
    public Map<String,Object> findByPage(Integer pageSize,Integer pageNum){
        Map<String,Object> map = new HashMap();

        Page<User> userPage = userRepository.findAll(new Pageable() {
            @Override
            public int getPageNumber() {
                return pageNum;
            }

            @Override
            public int getPageSize() {
                return pageSize;
            }

            @Override
            public long getOffset() {
                logger.info("=======>：" + (pageNum - 1) * pageSize);
                return (pageNum - 1) * pageSize;
            }

            @Override
            public Sort getSort() {
                return new Sort("id");
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        });

        List<User> list = userPage.getContent();
        long count = userPage.getTotalElements();
        int totalPages = userPage.getTotalPages();

        map.put("list",list);
        map.put("count",count);
        map.put("totalPages",totalPages);

        return map;
    }
}
