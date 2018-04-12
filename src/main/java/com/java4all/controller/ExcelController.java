package com.java4all.controller;

import com.java4all.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: momo
 * Date: 2018/4/11
 * Description:表格处理
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    private static Logger logger = LoggerFactory.getLogger("");

    @Autowired
    private ExcelService excelService;

    @RequestMapping(value = "parseExcel",method = RequestMethod.POST)
    public String parseExcel(MultipartFile file){
        try {
            String ss = excelService.parseExcel(file);
            return ss;
        }catch (Exception ex){
            logger.info("文件解析出错",ex);
            return "文件解析出错";
        }
    }
}
