package com.example.base.java.demobasejava.design_pattern.abs_factory;

/**
 * @author benjamin
 * created at 2019/8/22
 * <p>
 * 具体的工厂
 */
public class ConcreteFactoryA implements AbsFactory {
    @Override
    public AbsProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbsProductB createProductB() {
        return new ConcreteProductB1();
    }
}
