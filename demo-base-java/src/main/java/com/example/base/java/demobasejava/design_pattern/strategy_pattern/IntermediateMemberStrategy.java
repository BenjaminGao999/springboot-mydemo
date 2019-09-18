package com.example.base.java.demobasejava.design_pattern.strategy_pattern;

/**
 * @author benjamin
 * created at 2019/9/16
 * 中级会员
 */
public class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("中级会员9折");
        return booksPrice * 0.9;
    }

}
