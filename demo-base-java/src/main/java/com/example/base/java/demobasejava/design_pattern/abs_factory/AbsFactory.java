package com.example.base.java.demobasejava.design_pattern.abs_factory;

/**
 * @author benjamin
 * created at 2019/8/22
 * 抽象工厂
 */
public interface AbsFactory {
    // 冰箱
    AbsProductA createProductA();

    // 洗衣机
    AbsProductB createProductB();

}
