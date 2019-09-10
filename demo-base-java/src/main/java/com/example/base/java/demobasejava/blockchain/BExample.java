package com.example.base.java.demobasejava.blockchain;

/**
 * @author benjamin
 * created at 2019/9/4
 */
public class BExample {
    public static void main(String[] args) {

        float principalUSDT = 100f;
        int leverage = 4;
        float btcPriceBorrow = 10600f;
        float btcPriceReturn = 10600f;
        int hours = 24 * 7;
//        float interestRate = 0.0001f;
        float interestRate = 0.001f;

        String interest = getInterest(principalUSDT, leverage, btcPriceBorrow, btcPriceReturn, interestRate, hours);

        System.out.println("interest usdt = " + interest);


        float brust = getBrust(principalUSDT, leverage, btcPriceBorrow, btcPriceReturn, interestRate);

        System.out.println("getBrust = " + brust / 24);
    }

    /**
     * 扣除利息爆仓线
     *
     * @param principalUSDT
     * @param leverage
     * @param btcPriceBorrow
     * @param btcPriceReturn
     * @param interestRate
     * @return
     */
    private static int getBrust(float principalUSDT, int leverage,
                                float btcPriceBorrow, float btcPriceReturn,
                                float interestRate) {
        int houres = 1;

        float currentSafeBTCRate;


        do {
            Float insterest = Float.valueOf(getInterest(principalUSDT, leverage, btcPriceBorrow, btcPriceReturn, interestRate, houres++));
            float balance = principalUSDT - insterest;
            float loanBTC = (principalUSDT / btcPriceBorrow) * leverage;

            currentSafeBTCRate = balance / btcPriceBorrow / loanBTC;

        } while (currentSafeBTCRate > 0.1);

        return houres;
    }

    /**
     * @param principalUSDT  本金
     * @param leverage       杠杆
     * @param btcPriceBorrow 借钱时的价格
     * @param btcPriceReturn 还钱时的价格
     * @param hours          计息时间/计息次数
     * @param interestRate   利率
     * @return
     */
    private static String getInterest(float principalUSDT, int leverage,
                                      float btcPriceBorrow, float btcPriceReturn,
                                      float interestRate, int hours) {
        // 1. 贷款BTC数量
        float loanBTC = (principalUSDT / btcPriceBorrow) * leverage;

        // 2. 利息
        float interest = loanBTC * interestRate * hours * btcPriceReturn;

        return String.valueOf(interest);

    }


}
