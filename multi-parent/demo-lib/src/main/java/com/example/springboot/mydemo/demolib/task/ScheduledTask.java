package com.example.springboot.mydemo.demolib.task;

import com.example.springboot.mydemo.demolib.service.ServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author benjamin
 * created at 2019/5/10
 */

@Component
public class ScheduledTask {

    @Autowired
    ServiceDemo serviceDemo;


    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    private void timerTask() {
        String time = new Timestamp(System.currentTimeMillis()).toString();
        System.out.println(time);

        System.out.println("demolibval>>" + serviceDemo.getDdemoLibVal());

    }
}
