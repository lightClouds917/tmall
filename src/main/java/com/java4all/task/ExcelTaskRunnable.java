package com.java4all.task;

import com.java4all.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: momo
 * Date: 2018/4/14
 * Description:Excel解析
 */
public class ExcelTaskRunnable implements Runnable{

    private static Logger logger = LoggerFactory.getLogger("");
    private ExcelService excelService;
    private MultipartFile file;

    @Override
    public void run() {
        try {
            excelService.parseExcel(file);
            logger.info("=======>处理数据线程名称："+Thread.currentThread().getName());
        }catch (Exception ex){
            logger.info("==========>异步处理Excel出错");
        }
    }

    public void setExcelService(ExcelService excelService) {
        this.excelService = excelService;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
