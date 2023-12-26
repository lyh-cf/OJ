package com.算法笔记.排序;

import java.util.Arrays;

/*
 *@title QuickSortPlus todo 选择中位数做基准数，提高算法的鲁棒性
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/26 21:12
 */
public class QuickSortPlus {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 选择中位数作为标准元素
        int mid = left + (right - left) / 2;
        swap(arr, left, mid);

        int pivot = arr[left];
        int i = left + 1;
        int j = right;

        while (true) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (j >= i && arr[j] >= pivot) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
        }

        swap(arr, left, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
