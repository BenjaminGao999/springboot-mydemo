package com.example.springboot.mydemo.demoservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author benjamin
 * created at 2019/5/10
 */
@Configuration
public class AppConfig {

    @Value("${demo-lib-key}")
    private String lib_demo_key;

}
