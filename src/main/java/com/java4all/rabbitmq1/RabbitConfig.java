package com.java4all.rabbitmq1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: momo
 * Date: 2018/6/15
 * Description:配置信息，队列，交换机
 */
@Configuration
public class RabbitConfig {

    //队列 queue1
    @Bean
    public Queue queue1(){
        return new Queue("queue1");
    }

}
