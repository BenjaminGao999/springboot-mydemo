package com.example.springbootmydemo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author benjamin
 * created at 2019/5/10
 */
@Component
public class ScheduledServiceImpl {

/*
    @Scheduled(fixedDelayString = "${eventTracking.delayFixed}")
    private void doTask() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("current time >>> " + timestamp.toString());
    }*/
}
