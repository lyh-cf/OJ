package com.算法笔记.排序;

import java.util.Arrays;

/*
 *@title MergeSort
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/26 21:31
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        int[] temp = new int[n];
        split(arr, temp, 0, n - 1);
    }

    //双指针
    private static void merge(int[] arr, int[] temp, int iStart, int iEnd, int jStart, int jEnd) {
        int k = iStart;//todo
        while (iStart <= iEnd && jStart <= jEnd) {
            if (arr[iStart] < arr[jStart]) {
                temp[k] = arr[iStart];
                iStart++;
            } else {
                temp[k] = arr[jStart];
                jStart++;
            }
            k++;
        }
        if (iStart <= iEnd) {
            System.arraycopy(arr, iStart, temp, k, iEnd - iStart + 1);
        }
        if (jStart <= jEnd) {
            //原数组，原数组开始复制的起始索引，目标数组，目标数组开始复制的起始索引，长度
            System.arraycopy(arr, jStart, temp, k, jEnd - jStart + 1);
        }

    }

    private static void split(int[] arr, int[] temp, int left, int right) {
        //2.治：数据只剩一个时，即为有序
        //递归出口
        if (left == right) return;
        //1.分：每次从中间切一刀，处理的数据少一半
        int mid = left + (right - left) / 2;
        split(arr, temp, left, mid);
        split(arr, temp, mid + 1, right);
        //3.合：两个有序的结果，可以进行合并
        merge(arr, temp, left, mid, mid + 1, right);
        System.arraycopy(temp, left, arr, left, right - left + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}