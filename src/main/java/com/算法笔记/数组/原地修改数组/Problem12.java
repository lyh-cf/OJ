package com.算法笔记.数组.原地修改数组;

/*
 *@title Problem12
 *@description todo 283. 移动零
 *@author LYH
 *@version 1.0
 *@create 2023/12/2 21:51
 */
public class Problem12 {
    public void moveZeroes(int[] nums) {
        int slow=0,fast=0;
        while(fast!=nums.length){
            if(nums[fast]==0)fast++;
            else{
                nums[slow]=nums[fast];
                slow++;
                fast++;
            }
        }
        //将后面的元素都赋值为0
        for(int i=slow;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
