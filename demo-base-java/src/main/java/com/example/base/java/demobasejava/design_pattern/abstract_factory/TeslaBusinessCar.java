package com.example.base.java.demobasejava.design_pattern.abstract_factory;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public class TeslaBusinessCar implements TeslaCar {
    public void charge() {
        System.out.println("不用给我特斯拉商务车冲满电");
    }
}

