package com.example.springbootmydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootMydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMydemoApplication.class, args);
    }

}
