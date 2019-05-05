package com.example.springbootmydemo.scheduledtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author benjamin
 * created at 2019/5/5
 */
@Component
public class ScheduledTask {

/*    @Scheduled(cron = "0/5 * *  * * ? ")   //每5秒执行一次
    public void doTimerTask() {

        System.out.println("this is a timertask");
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {

        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }*/

    /**
     * 单个任务执行完之后延迟固定时间
     * 再重新开启新的任务
     * one by one 时间上非重叠的执行任务
     */
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() {
        long now = System.currentTimeMillis() / 1000;
        System.out.println("Fixed rate task with one second initial delay - " + now);
    }


}
