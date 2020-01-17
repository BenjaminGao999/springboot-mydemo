package com.example.demo.service;

import com.example.demo.utils.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author benjamin
 * created at 2019/10/28
 */
@Service
public class SpringAsyncServiceImpl {


    public void entry() throws ExecutionException, InterruptedException {

        System.out.println("entry thread name # " + Thread.currentThread().getName());

        SpringAsyncServiceImpl asyncService = BeanUtils.getBean(SpringAsyncServiceImpl.class);
//        asyncService.voidMethod();
        Future<String> aFuture = asyncService.fuyureReturn();

        System.out.println("entry end");

        System.out.println(aFuture.get());
    }

    @Async
    public void voidMethod() {
        System.out.println(" thread name  # " + Thread.currentThread().getName());
//        int i = 10 / 0;
    }

    @Async
    public Future<String> fuyureReturn() {

        FutureTask<String> futureTask = new FutureTask<>(() -> {

            Thread.sleep(1000L);

//            int i = 10 / 0;


            return Thread.currentThread().getName() + " # 我沉睡了1000ms 现在我醒来了";

        });

        futureTask.run();


        return futureTask;
    }

}
