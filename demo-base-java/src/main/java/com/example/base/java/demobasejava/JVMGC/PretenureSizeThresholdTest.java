package com.example.base.java.demobasejava.JVMGC;

/**
 * @author benjamin
 * created at 2019/12/14
 */
public class PretenureSizeThresholdTest {

    public static final int _1MB = 1024 * 1024;


    /**
     * 测试直接将对象分配在老年代 tenured generation
     * <p>
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8   -XX:+UseSerialGC  -XX:PretenureSizeThreshold=3145728
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {


        byte[] allocation1, allocation2, allocation3, allocation4;


        allocation1 = new byte[4 * _1MB];



    }


}
