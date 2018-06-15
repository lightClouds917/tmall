package com.java4all.rabbitmq1;

import com.java4all.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: momo
 * Date: 2018/6/15
 * Description:
 */
@RestController
@RequestMapping(value = "mq1")
public class UserController1 {

    @Autowired
    Producer1 producer1;

    @RequestMapping(value = "getUser1",method = RequestMethod.GET)
    public void getUser1(){
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setUserName("name"+i);
            user.setRealName("realName"+i);
            user.setPassword("0000"+i);
            //生产消息
            producer1.produce1(user);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
