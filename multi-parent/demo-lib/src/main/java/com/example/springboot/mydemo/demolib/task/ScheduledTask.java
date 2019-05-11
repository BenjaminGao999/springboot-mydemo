package com.example.springboot.mydemo.demolib.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author benjamin
 * created at 2019/5/10
 */

@Component
public class ScheduledTask {

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    private void timerTask() {
        String time = new Timestamp(System.currentTimeMillis()).toString();
        System.out.println(time);
    }
}
