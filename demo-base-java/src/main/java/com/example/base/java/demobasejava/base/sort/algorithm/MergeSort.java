package com.example.base.java.demobasejava.base.sort.algorithm;

import java.util.Arrays;

/**
 * @author benjamin
 * created at 2019/6/19
 */
public class MergeSort {

        /*
            Actually, arr[i++] = 1 is equivalent to

            int i1 = i;
            i = i + 1;
            arr[i1] = 1;

         */

    public static int[] sort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int num = a.length >> 1;
        int[] left = Arrays.copyOfRange(a, 0, num);
        int[] right = Arrays.copyOfRange(a, num, a.length);
        return mergeTwoArray(sort(left), sort(right));
    }

    public static int[] mergeTwoArray(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[a.length + b.length]; // 申请额外空间保存归并之后数据

        while (i < a.length && j < b.length) { //选取两个序列中的较小值放入新数组
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) { //序列a中多余的元素移入新数组
            result[k++] = a[i++];
        }
        while (j < b.length) {//序列b中多余的元素移入新数组
            result[k++] = b[j++];
        }

        System.out.println("        " + Arrays.toString(result));


        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
