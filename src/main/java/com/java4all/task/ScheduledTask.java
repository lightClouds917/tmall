package com.java4all.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Author: momo
 * Date: 2018/4/9
 * Description:定时任务类
 */
@Component
public class ScheduledTask {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(fixedRate = 10000)
    public void printTime(){
        logger.info("定时任务，现在时间："+System.currentTimeMillis());
    }


}
