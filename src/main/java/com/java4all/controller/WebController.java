package com.java4all.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: momo
 * Date: 2018/3/30
 * Description:
 */
@Controller
@RequestMapping("web")
public class WebController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger("");
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(MultipartFile file){
        //String originalFilename = file.getOriginalFilename();
        //String fileName = file.getName();
        //logger.info("originalFilename:"+originalFilename);
        //logger.info("fileName:"+fileName);
        return "index2";
    }
}
