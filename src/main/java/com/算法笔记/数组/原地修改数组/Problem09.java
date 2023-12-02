package com.算法笔记.数组.原地修改数组;

/*
 *@title Problem09
 *@description todo 26. 删除有序数组中的重复项
 *@author LYH
 *@version 1.0
 *@create 2023/12/2 16:09
 */
public class Problem09 {
    public int removeDuplicates(int[] nums) {
         int slow=0,fast=0;
         while(fast<nums.length){
             //nums的第0位索引处一定会在最终答案里
             if(nums[slow]!=nums[fast]){
                 slow++;
                 nums[slow]=nums[fast];
             }
             fast++;
         }
         return slow+1;
    }
}
