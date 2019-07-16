package com.example.base.java.demobasejava.design_pattern.responsibility_chain;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public class ResponsibilityA implements Responsibility {

    @Override
    public void process(Request request, ResponsibilityChain chain) {
        //前置增强
        System.out.println("Before Responsibility-A done something...");
        //ResponsibilityA处理完以后调用ResponsibilityChain的process方法交给下一个责任逻辑处理
        chain.process(request);
        //后置增强
    }

}


