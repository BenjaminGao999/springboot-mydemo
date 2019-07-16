package com.example.base.java.demobasejava.design_pattern.abstract_factory;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public class SportCarFactory implements CarFactory {
    public BenzCar getBenzCar() {
        return new BenzSportCar();
    }

    public TeslaCar getTeslaCar() {
        return new TeslaSportCar();
    }
}

