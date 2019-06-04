package com.example.springboot.mydemo.demolib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author benjamin
 * created at 2019/5/11
 */

@Component
public class ServiceDemo {

    @Value("${demo-lib-val}")
    private int demoLibVal;

    @Autowired
    ServiceDemo2 serviceDemo2;


    public int getDdemoLibVal() {
        System.out.println(serviceDemo2.getDemoLibkey());

        return demoLibVal;

    }
}
