package com.算法笔记.数组.前缀和;

/*
 *@title Problem23
 *@description todo
 *@author LYH
 *@version 1.0
 *@create 2023/12/6 16:40
 */
public class Problem23 {
    private int[] preSum;

    public Problem23(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        //实际上是 preSum[right+1]-preSum[left-1+1];
        return preSum[right+1]-preSum[left];
    }
}
