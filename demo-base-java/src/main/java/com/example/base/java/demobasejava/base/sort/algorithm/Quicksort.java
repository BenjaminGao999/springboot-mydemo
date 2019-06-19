package com.example.base.java.demobasejava.base.sort.algorithm;

import java.util.Arrays;

/**
 * @author benjamin
 * created at 2019/6/19
 *
 * (1) low=L high=R 将基准数挖出形成第一个坑a[low]
 * (2) high-- 由后向前找比基准小的数， 找到后挖出此数填前一个坑a[low]中
 * (3) low++ 由前到后找比基准大的数， 找到后挖出此数填前一个坑a[high]中
 * (4) 重复(2)(3) 直到low==high, 将基准数填入a[low]
 *
 * 演绎-归纳法
 */
public class Quicksort {
    /**
     * 快速排序（挖坑法递归）
     *
     * @param arr  待排序数组
     * @param low  左边界
     * @param high 右边界
     */
    public static void sort(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;
        int temp = arr[left]; //挖坑1：保存基准的值

        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right]; //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left]; //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
        }
        arr[left] = temp; //基准值填补到坑3中，准备分治递归快排
        System.out.println("Sorting: " + Arrays.toString(arr));
        sort(arr, low, left - 1);
        sort(arr, left + 1, high);
    }

}
