package com.java4all.controller;

import com.java4all.dao.UserRepository;
import com.java4all.entity.User;
import com.java4all.service.UserService;
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
    @Autowired
    private UserService userService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public User getList(Integer id){
        User user = userService.getById(id);
        return user;
    }

    /**-------------jpa----------------------*/

    /**
     * 查询操作
     * @return
     */
    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public User findById(Integer id){
        User user = userRepository.findById(id);
        return user;
    }

    /**
     * 删除操作
     * @param id
     */
    @RequestMapping(value = "deleteById",method = RequestMethod.GET)
    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    /**
     * 添加User
     * @return
     */
    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    public String addUser(){

        User user = new User();
        user.setUserName("momo456");
        user.setCountry("中国啊");
        userRepository.saveAndFlush(user);
        return "操作成功";
    }

    /**
     * 根据userName查询user
     * @param userName
     * @return
     */
    @RequestMapping(value = "findByUserName",method = RequestMethod.GET)
    public User findByUserName(String userName){
        User user = userRepository.findUserByUserName(userName);
        return user;
    }

    /**
     * 分页查询
     * @param pageSize 每页个数
     * @param pageNum 页码
     * @return
     */
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
                //logger.info("=======>：" + (pageNum - 1) * pageSize);
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

    /**-------------jpa----------------------*/


}
