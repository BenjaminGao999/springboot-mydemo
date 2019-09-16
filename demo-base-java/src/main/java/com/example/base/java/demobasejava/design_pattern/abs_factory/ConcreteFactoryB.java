package com.example.base.java.demobasejava.design_pattern.abs_factory;

/**
 * @author benjamin
 * created at 2019/8/22
 * 格力工厂
 */
public class ConcreteFactoryB implements AbsFactory {
    @Override
    public AbsProductA createProductA() {
        return new ConcreteProductA2GeLi();
    }

    @Override
    public AbsProductB createProductB() {
        return new ConcreteProductB2GeLi();
    }
}
