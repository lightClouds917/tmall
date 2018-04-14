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
            logger.info("=======>主线程名称："+Thread.currentThread().getName());

            //1.同步方式
            //String ss = excelService.parseExcel(file);
            //logger.info("===========>处理完毕");
            //return ss;

            //2.异步方式，创建新线程
            //ExcelTaskRunnable runnable = new ExcelTaskRunnable();
            //Thread thread = new Thread(runnable);
            //runnable.setExcelService(excelService);
            //runnable.setFile(file);
            //thread.start();
            //logger.info("===========>处理完毕");
            //return "处理完毕";

            //3.异步方式，springboot自带
            String ss = excelService.parseExcel(file);
            logger.info("===========>处理完毕");
            return "处理完毕";
        }catch (Exception ex){
            logger.info("文件解析出错",ex);
            return "文件解析出错";
        }
    }
}
