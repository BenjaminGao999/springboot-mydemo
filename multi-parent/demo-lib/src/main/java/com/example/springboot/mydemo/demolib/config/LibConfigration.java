package com.example.springboot.mydemo.demolib.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author benjamin
 * created at 2019/5/12
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = {
        "com.example.springboot.mydemo.demolib"
})
public class LibConfigration {
}
