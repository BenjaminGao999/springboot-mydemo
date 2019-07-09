package com.example.base.java.demobasejava.base.sort.algorithm;

import java.util.Arrays;

/**
 * @author benjamin
 * created at 2019/6/19
 * 直接插入排序
 */
public class DirectInsertSort {

    public static void main(String[] args) {


        int[] a = {4, 3, 7, 5, 7, 8, 0, -1};
        sort(a);

        System.out.println(Arrays.toString(a));
    }

    /**
     * 移位法
     */
    static void sort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 1; i < a.length; ++i) {
            int j = i - 1;
            int temp = a[i]; // 先取出待插入数据保存，因为向后移位过程中会把覆盖掉待插入数
            while (j >= 0 && a[j] > temp) { // 如果待是比待插入数据大，就后移
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp; // 找到比待插入数据小的位置，将待插入数据插入
        }
    }


}
