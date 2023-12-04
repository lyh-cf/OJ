package com.算法笔记.数组.二分搜索;

/*
 *@title Problem13
 *@description todo 34. 在排序数组中查找元素的第一个和最后一个位置
 *@author LYH
 *@version 1.0
 *@create 2023/12/4 16:48
 */
public class Problem13 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        if(nums==null||nums.length==0)return ans;
        ans[0]=left_bound(nums,target);
        ans[1]=right_bound(nums,target);
        return ans;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left - 1 < 0) return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
