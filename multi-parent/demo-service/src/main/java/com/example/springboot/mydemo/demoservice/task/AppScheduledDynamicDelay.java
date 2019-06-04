package com.example.springboot.mydemo.demoservice.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author benjamin
 * created at 2019/5/11
 */
@Component
public class AppScheduledDynamicDelay {

    @Value("${demo-lib-key}")
    private String demoLibKey;



    @Scheduled(fixedDelayString = "${demo-delay}", initialDelay = 1000)
    private void appTask() {

      /*  String time = new Timestamp(System.currentTimeMillis()).toString();

        System.out.println("app task time >>>" + time);
        System.out.println(" IN app demo lib key >>>"+demoLibKey);
*/

    }
}
