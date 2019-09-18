package com.example.base.java.demobasejava.design_pattern.strategy_pattern;

/**
 * @author benjamin
 * created at 2019/9/16
 */
public class Price {
    //持有一个具体的策略对象
    private MemberStrategy strategy;

    /**
     * @param strategy
     */
    public Price(MemberStrategy strategy) {
        super();
        this.strategy = strategy;
    }

    /**
     * 计算图书的价格
     *
     * @param booksPrice 图书的原价
     * @return 计算出打折后的价格
     */
    public double quote(double booksPrice) {
        return this.strategy.calcPrice(booksPrice);
    }
}