package com.java4all.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: momo
 * Date: 2018/4/11
 * Description:Excel解析工具类
 */
public class ExcelParserUtil {

    private static Logger logger = LoggerFactory.getLogger("");

    /**
     * 是否是2003的excel，返回true 是2003
     * @param filePath
     * @return
     */
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 是否是2007的excel，返回true 是2007
     * @param filePath
     * @return
     */
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 验证是否为EXCEL文件
     * @param filePath
     * @return
     */
    public static boolean validateExcel(String filePath){
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))){
            return false;
        }
        return true;
    }

}
