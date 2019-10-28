package com.example.demo.service;

import com.example.demo.utils.SpringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author benjamin
 * created at 2019/10/28
 */
@Service
public class SpringAsyncServiceImpl {


    public void entry() {

        System.out.println("entry thread name # " + Thread.currentThread().getName());

        SpringAsyncServiceImpl asyncService = SpringUtils.getBean(SpringAsyncServiceImpl.class);
        asyncService.voidMethod();
    }

    @Async
    public void voidMethod() {
        System.out.println(" thread name  # " + Thread.currentThread().getName());
    }


}
