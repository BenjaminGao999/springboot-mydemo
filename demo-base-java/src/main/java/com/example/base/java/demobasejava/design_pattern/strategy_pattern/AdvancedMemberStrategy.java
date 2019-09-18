package com.example.base.java.demobasejava.design_pattern.strategy_pattern;

/**
 * @author benjamin
 * created at 2019/9/16
 * 高级会员
 */
public class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("高级会员8折");
        return booksPrice * 0.8;
    }

}
