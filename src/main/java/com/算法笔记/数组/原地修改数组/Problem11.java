package com.算法笔记.数组.原地修改数组;

/*
 *@title Problem11
 *@description todo 27. 移除元素
 *@author LYH
 *@version 1.0
 *@create 2023/12/2 21:42
 */
public class Problem11 {
    public int removeElement(int[] nums, int val) {
        int slow=0,fast=0;
        int length=0;
        while(fast!=nums.length){
            if(nums[fast]==val)fast++;
            else{
                nums[slow]=nums[fast];
                slow++;
                fast++;
                length++;
            }
        }
        return length;
    }
}
