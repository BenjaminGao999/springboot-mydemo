package com.example.base.java.demobasejava.base.sort.algorithm;

import java.util.Arrays;

/**
 * @author benjamin
 * created at 2019/6/19
 * <p>
 * 相邻元素比较
 * 时间复杂度 o(n) o(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int length = array.length;
        //外层：需要length-1次循环比较
        for (int i = 0; i < length - 1; i++) {
            boolean flag = true;
            //内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    //交换数组array的j和j+1位置的数据
                    swap(array, j, j + 1);
                    flag = false;
                }
            }

            if (flag) break;
        }
    }

    /**
     * 交换数组array的i和j位置的数据
     *
     * @param array 数组
     * @param i     下标i
     * @param j     下标j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

