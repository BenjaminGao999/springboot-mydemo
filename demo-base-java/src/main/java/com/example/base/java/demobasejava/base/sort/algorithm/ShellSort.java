package com.example.base.java.demobasejava.base.sort.algorithm;

import java.util.Arrays;

/**
 * @author benjamin
 * created at 2019/6/19
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int gap = arr.length / 2;
        for (; gap > 0; gap = gap / 2) { //不断缩小gap，直到1为止
            for (int j = 0; (j + gap) < arr.length; j++) {
                for (int k = j; (k + gap) < arr.length; k += gap) { //使用当前gap进行组内插入排序
                    if (arr[k] > arr[k + gap]) { //交换操作
                        arr[k] = arr[k] + arr[k + gap];
                        arr[k + gap] = arr[k] - arr[k + gap];
                        arr[k] = arr[k] - arr[k + gap];
                        System.out.println("    Sorting:  " + Arrays.toString(arr));
                    }
                }
            }
        }
    }
}
