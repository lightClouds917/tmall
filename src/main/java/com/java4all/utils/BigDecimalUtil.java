package com.java4all.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Author: momo
 * Date: 2018/3/28
 * Description:处理BigDecimal的工具类
 */
public class BigDecimalUtil {

    private static Logger logger = LoggerFactory.getLogger("");

    /**
     * 公式：(nowSum-lastSum)/lastSum ,保留4位小数，转为百分数
     * @param nowSum
     * @param lastSum
     * @return
     */
    public static String getTongbiPercent(BigDecimal nowSum, BigDecimal lastSum){

        String sumYoYStr = "";
        logger.info("===============>参数1："+nowSum);
        logger.info("===============>参数2："+lastSum);
        try {

            //分母为0 或者为 负数
            if (null == lastSum || null == nowSum
                    || lastSum.compareTo(BigDecimal.ZERO) == 0 || lastSum.compareTo(BigDecimal.ZERO) == -1) {
                sumYoYStr = "-";
            } else {
                //计算同比   （今年值-去年同期值）/去年同期值
                BigDecimal big = ((nowSum.subtract(lastSum)).divide(lastSum,BigDecimal.ROUND_HALF_UP, 4));
                logger.info("============>（参数1-参数2）/参数2 ： 计算结果："+big);

                //  处理如0.00003之类的特殊情况
                BigDecimal zh = new BigDecimal(0.0001);
                BigDecimal fu = new BigDecimal(-0.0001);
                BigDecimal ze = new BigDecimal(0.0000);

                if (big.compareTo(BigDecimal.ZERO) == 1 && big.compareTo(zh) == -1) {//        0.0000 --0.0001之间
                    //sumYoYStr = "0.0001";
                    sumYoYStr = "0.01%";
                } else if (big.compareTo(fu) == 1 && big.compareTo(BigDecimal.ZERO) == -1) {// -0.0001 --0.0000之间
                    //sumYoYStr = "-0.0001";
                    sumYoYStr = "0.01%";
                } else {
                    sumYoYStr = big.multiply(new BigDecimal("100")).setScale(2) + "%";
                    logger.info("===============>处理百分号后，同比："+sumYoYStr);

                }
            }
            return sumYoYStr;
        }catch (Exception ex){
            logger.info("==================>计算同比出错：",ex);
            return "0.00%";
        }
    }
}
