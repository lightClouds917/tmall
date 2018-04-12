package com.java4all.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Author: momo
 * Date: 2018/4/11
 * Description:表格处理
 */
public interface ExcelService {

    /**
     * 解析Excel文件
     * @param file
     * @return
     * @throws Exception
     */
    String parseExcel(MultipartFile file) throws Exception;
}
