package com.example.base.java.demobasejava.design_pattern.state;

/**
 * @author liguangsheng
 * @Description: 状态接口
 * @date 2018年11月25日
 */
public interface State {
    void pay();

    void refund();

    void buy();

    void getCoffee();
}
