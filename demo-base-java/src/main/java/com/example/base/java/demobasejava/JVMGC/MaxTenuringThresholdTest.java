package com.example.base.java.demobasejava.JVMGC;

/**
 * @author benjamin
 * created at 2019/12/14
 */
public class MaxTenuringThresholdTest {

    public static final int _1MB = 1024 * 1024;


    /**
     * 长时间存活的对象： 由新生代晋升到老年代
     * <p>
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8   -XX:+UseSerialGC -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {


        byte[] allocation1, allocation2, allocation3, allocation4;


        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];

        // 触发minor gc， allocation1移动到survivor空间， 因为survivor空间不足， allocation2直接晋升到老年代

        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        // 触发 minor gc, allocation1因为年龄增长到2， 把allocation从survivor空间移动到 老年代
        allocation3 = new byte[4 * _1MB];

    }

}
