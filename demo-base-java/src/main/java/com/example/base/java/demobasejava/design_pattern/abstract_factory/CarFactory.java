package com.example.base.java.demobasejava.design_pattern.abstract_factory;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public interface CarFactory {

    public BenzCar getBenzCar();
    public TeslaCar getTeslaCar();
}

