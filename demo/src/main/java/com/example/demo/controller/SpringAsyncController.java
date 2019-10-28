package com.example.demo.controller;

import com.example.demo.service.SpringAsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author benjamin
 * created at 2019/10/28
 */
@RestController
public class SpringAsyncController {
    @Autowired
    SpringAsyncServiceImpl asyncService;

    @GetMapping("/api/async")
    public String testAsyncMethod() throws ExecutionException, InterruptedException {
        asyncService.entry();
        return "haha";
    }
}
