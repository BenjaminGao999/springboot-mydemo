package com.example.demo;

import com.example.demo.config.SomeProperties;
import com.example.demo.service.SpringAsyncServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    SpringAsyncServiceImpl asyncService;

    @Test
    public void asyncTest() throws ExecutionException, InterruptedException {

        asyncService.entry();
    }

    @Autowired
    SomeProperties someProperties;

    @Test
    public void someProperties(){

        System.out.println(someProperties.toString());
    }


}
