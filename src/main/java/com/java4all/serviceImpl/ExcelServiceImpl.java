package com.java4all.serviceImpl;

import com.java4all.entity.User;
import com.java4all.service.ExcelService;
import com.java4all.utils.ExcelParserUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: momo
 * Date: 2018/4/11
 * Description:
 */
@Service
public class ExcelServiceImpl implements ExcelService{

    private static Logger logger = LoggerFactory.getLogger("");

    /**
     * 分析数据
     * @param list
     * @return
     */
    @Async
    public List getUserByProvince(List<User> list) {
        List<User> list1 = new ArrayList();
        try {
            synchronized (list1){
                logger.info("=======>处理数据线程名称："+Thread.currentThread().getName());
                for (int i = 0,length = list.size();i < length;i++){
                    User user = list.get(i);
                    if("陕西省".equals(user.getProvince())){
                        list1.add(user);
                        list1.wait(60);
                        //logger.info("==========>符合条件："+user.getRealName());
                    }
                }
            }
        }catch (Exception ex){
            logger.info("=========>数据分析出错");
        }
        return list1;
    }

    @Async
    @Override
    public String parseExcel(MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
        logger.info("=======>文件名："+fileName);

        //判断是否为null
        if(null == file){
            return "文件为空，请重新上传";

        }

        //判断是否为Excel格式
        if(!ExcelParserUtil.validateExcel(fileName)){
            return "文件必须是Excel格式，请重新上传";
        }

        //判断内容是否为空
        long size = file.getSize();
        if(0 == size){
            return "文件内容为空，请重新上传";
        }

        //将文件备份到服务器/本地
        File fileDir = new File("E:\\fileDir");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        File fileNew = new File(fileDir,System.currentTimeMillis()+ "-"+ fileName);
        file.transferTo(fileNew);

        //创建输入流
        InputStream is = new FileInputStream(fileNew);
        Workbook wb = null;

        //根据文件名判断文件是2003还是2007
        if(ExcelParserUtil.isExcel2003(fileName)){
            wb = new HSSFWorkbook(is);
        }else {
            wb = new XSSFWorkbook(is);
        }

        List<User> users = readExcel(wb);

        //处理数据
        List listPS = this.getUserByProvince(users);

        logger.info("=======>处理完毕，共解析出:"+users.size()+"条数据，符合条件数据有："+listPS.size()+"条");

        return "处理完毕";
    }

    /**
     * 解析Excel表格数据
     * @param wb
     * @return
     */
    public List<User> readExcel(Workbook wb){
        //错误信息
        String errorMessage = "";
        //获取第一个sheet
        Sheet sheet0 = wb.getSheetAt(0);
        //行数
        int totalRows = sheet0.getPhysicalNumberOfRows();
        //列数
        int totalCells = 0;
        //第二行算起且不为空
        if(totalRows >= 2 &&  null != sheet0.getRow(1)){
            totalCells = sheet0.getRow(1).getPhysicalNumberOfCells();
        }

        //解析数据转为user对象
        List<User> list = new ArrayList<>();
        for(int i = 1,length = totalRows;i < totalRows;i ++){
            Row row = sheet0.getRow(i);
            if(null == row){
                logger.info("===========>第"+i+"行数据有问题，请核查数据！");
            }
            User user = new User();

            user.setUserName(row.getCell(1).getStringCellValue());
            user.setRealName(row.getCell(2).getStringCellValue());
            user.setPassword(row.getCell(3).getStringCellValue());
            user.setCountry(row.getCell(4).getStringCellValue());
            user.setProvince(row.getCell(5).getStringCellValue());
            user.setCity(row.getCell(6).getStringCellValue());
            user.setPhone(row.getCell(7).getNumericCellValue()+"");
            user.setDevLanguage(row.getCell(9).getStringCellValue());
            user.setSchoolName(row.getCell(10).getStringCellValue());
            user.setSchoolMajor(row.getCell(11).getStringCellValue());

            list.add(user);
        }
        return list;
    }
}
