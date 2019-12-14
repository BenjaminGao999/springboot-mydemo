package com.example.base.java.demobasejava.JVMGC;

/**
 * @author benjamin
 * created at 2019/12/14
 */
public class DynamicAgeTest {

    public static final int _1MB = 1024 * 1024;


    /**
     * 动态年龄判断： survivor空间中相同年龄的对象的大小大于survivor空间大小的一半，
     * 则将survivor空间中大于或等于该年龄的对象移动到老年代
     * <p>
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8   -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];

        allocation3 = new byte[4 * _1MB];
        // 触发minor gc， 因为survivor空间不足， allocation3晋升到老年代， allocation1,allocation2被移动到survivor空间
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;

        // 触发minor gc , 清除allocation4, 所以eden空间是空的， 因为survivor空间中相同年龄的对象的大小大于survivor空间大小的一半， 所以将大于或等于1的对象移动到老年代
        allocation4 = new byte[4 * _1MB];

    }

}
