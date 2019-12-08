package com.example.demo.cglibtest;

/**
 * @Package: org.vincent.proxy.cglibproxy <br/>
 * @Description： Cglib 代理模式中 被代理的委托类 <br/>
 * @author: lenovo <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2019 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by lenovo on 2018/12/26-17:55 <br/>
 */
public class Dog {
    public String call() {
        System.out.println("wang wang wang");
        return "Dog ..";
    }

    // 私有方法不可被重写
    //由于是继承方式,如果是 static方法,private方法,final方法等描述的方法是不能被代理的
    private String sleep() {

        System.out.println("I am sleeping");

        return "don't brother me ";
    }
}