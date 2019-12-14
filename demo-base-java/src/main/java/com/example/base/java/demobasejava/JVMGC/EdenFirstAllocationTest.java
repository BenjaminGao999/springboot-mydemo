package com.example.base.java.demobasejava.JVMGC;


/**
 * @author benjamin
 * created at 2019/7/1
 */
public class EdenFirstAllocationTest {
    public static final int _1MB = 1024 * 1024;


    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=1 -XX:+UseSerialGC -XX:+PrintTenuringDistribution
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        byte[] allocation1, allocation2, allocation3, allocation4;


        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        // 执行 minor gc, survivor空间不足， allocation1, allocation2 直接晋级到老年代

        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];

        allocation4 = null;
        // 执行minor gc，allocation4直接被清理，  survivor空间不足， allocation3直接晋级到老年代
        allocation4 = new byte[4 * _1MB];


    }


}
