package com.java4all.rabbitmq1;

import com.java4all.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

/**
 * Author: momo
 * Date: 2018/6/15
 * Description:消息消费者
 */
//监听队列queue1
@Configuration
@RabbitListener(queues = "queue1")
public class Consumer1 {

    /**接收到信息后进行消费（处理）*/
    @RabbitHandler
    public void process1(User user){
        System.out.println("Consumer1:"+ LocalTime.now()+"----"+user.toString());
    }
}
