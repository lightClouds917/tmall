package com.java4all.controller;

import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 106.54.227.205
 * 账号/密码:apollo/admin
 * @author ITyunqing
 * @date 2020年03月11日 10:45:44
 */
@RestController
@RequestMapping("apollo")
public class ApolloController {

    @Value("${tmall}")
    public String tmall;

    @RequestMapping(value = "test")
    public String  test(){
        for(int i = 0;i < 1000;i++){
            System.out.println("tmall="+tmall);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return"Apollo test";
    }

    public String getTmall() {
        return tmall;
    }

    public void setTmall(String tmall) {
        this.tmall = tmall;
    }
}
