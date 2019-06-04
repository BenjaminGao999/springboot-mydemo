package com.example.springboot.mydemo.demolib.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author benjamin
 * created at 2019/5/12
 */
@Component
public class ServiceDemo2 {

    @Value("${demo-lib-key}")
    private String demoLibkey;

    public String getDemoLibkey() {
        return demoLibkey;
    }
}
