package com.算法笔记.数组.二分搜索;

/*
 *@title LeftBound
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/3 21:01
 */
public class LeftBoundTemplate {
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length;//注意 right 的值
        while (left < right) {
            //防止 left+right 过大
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;//注意
            } else if (nums[mid] < target) {
                left = mid + 1;//注意
            } else if (nums[mid] > target) {
                right = mid;//注意
            }
        }
        //此时 target 比所有的数都大，left 一直右移直到等于 right
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }
}
