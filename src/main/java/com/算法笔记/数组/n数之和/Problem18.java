package com.算法笔记.数组.n数之和;

import java.util.Arrays;

/*
 *@title Problem18
 *@description todo 167. 两数之和 II - 输入有序数组
 *@author LYH
 *@version 1.0
 *@create 2023/12/5 15:58
 */
public class Problem18 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4};
        System.out.println(Arrays.toString(twoSum(numbers, 6)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        // right = numbers.length - 1
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                //题目要求返回的索引是从 1 开始的
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
