package com.example.base.java.demobasejava.design_pattern.strategy_pattern;

/**
 * @author benjamin
 * created at 2019/9/16
 */
public class StrategyMain {

    public static void main(String[] args) {
        AdvancedMemberStrategy strategy = new AdvancedMemberStrategy();
        Price price = new Price(strategy);
        double quote = price.quote(100D);
        System.out.println("quote " + quote);
    }
}
