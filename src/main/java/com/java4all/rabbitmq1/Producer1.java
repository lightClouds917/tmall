package com.java4all.rabbitmq1;

import com.java4all.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: momo
 * Date: 2018/6/15
 * Description:消息生产者
 */
@Component
public class Producer1 {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**发送消息*/
    public void produce1(User user){
        rabbitTemplate.convertAndSend("queue1",user);
    }

}
