package com.example.base.java.demobasejava.design_pattern.strategy_pattern;

/**
 * @author benjamin
 * created at 2019/9/16
 */
public interface MemberStrategy {
    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    double calcPrice(double booksPrice);
}
