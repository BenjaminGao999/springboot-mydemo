package com.example.base.java.demobasejava.design_pattern.responsibility_chain;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public interface Responsibility {

    void process(Request request, ResponsibilityChain chain);
}

