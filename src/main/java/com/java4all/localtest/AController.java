package com.java4all.localtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhongxiang
 * @date 2019年10月11日 17:54:15
 */
@RestController
@RequestMapping("aController")
public class AController {

    @GetMapping("a")
    public String a(){
        return "aaa";
    }
}
