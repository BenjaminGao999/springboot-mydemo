package com.example.base.java.demobasejava.proxyTest;

/**
 * @author benjamin
 * created at 2019/7/3
 */
public class MyInterfaceImpl implements MyInterface {
    public void method() {
        System.out.println("method");
    }


    public void methodB() {
        System.out.println("BBB");
    }

    public void methodC() {

        System.out.println("CCC");
        methodB();
    }
}

