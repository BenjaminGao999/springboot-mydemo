package com.example.base.java.demobasejava.base.sort.algorithm;

import java.util.Arrays;

/**
 * @author benjamin
 * created at 2019/6/19
 * <p>
 * （1） 待排序序列中找到最小的
 * （2） 如果待排序序列中最小的不是第一个， 则将其与第一个互换
 * （3） 从余下的N-1个元素中，找出最小的，重复（1）（2），直到排序结束
 */
public class SelectSort {

    public static void main(String[] args) {


        int[] a = {4, 3, 7, 5, 7, 8, 0, -1};
        sort(a);

        System.out.println(Arrays.toString(a));

    }
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) { //选出之后待排序中值最小的位置
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                arr[min] = arr[i] + arr[min];
                arr[i] = arr[min] - arr[i];
                arr[min] = arr[min] - arr[i];
            }
        }
    }
}