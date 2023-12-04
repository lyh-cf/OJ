package com.算法笔记.数组.二分搜索;

/*
 *@title RightBoundTemplate
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/3 21:09
 */
public class RightBoundTemplate {
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length;//注意 right 的值
        while (left < right) {
            //防止 left+right 过大
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;//注意
            } else if (nums[mid] < target) {
                left = mid + 1;//注意
            } else if (nums[mid] > target) {
                right = mid;//注意
            }
        }
        //此时 left-1 索引越界
        if (left - 1 < 0) return -1;
        //判断 nums[left] 是不是target
        return nums[left - 1] == target ? (left - 1) : -1;
    }
}
