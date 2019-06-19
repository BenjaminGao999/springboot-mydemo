package com.example.base.java.demobasejava.base.sort.algorithm;

/**
 * @author benjamin
 * created at 2019/6/19
 * 直接插入排序
 */
public class DirectInsertSort {

    /**
     * 移位法
     *
     * @param a
     */
    public static void sort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int temp = a[i]; // 先取出待插入数据保存，因为向后移位过程中会把覆盖掉待插入数
            while (j >= 0 && a[j] > a[i]) { // 如果待是比待插入数据大，就后移
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp; // 找到比待插入数据小的位置，将待插入数据插入
        }
    }


}
