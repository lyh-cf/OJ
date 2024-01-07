package com.算法笔记.双周赛.T121;

/*
 *@title Problem02
 *@description todo 100168. 使数组异或和等于 K 的最少操作次数
 *@author LYH
 *@version 1.0
 *@create 2024/1/6 22:39
 */
public class Problem02 {
    public int minOperations(int[] nums, int k) {
        int result=0,count=0;
        for(int num:nums){
            result=result^num;
        }
        for(int i=1;i<=32;i++){
            // &1 取末尾的二进制位
            if((result&1)!=(k&1)){
                count++;
            }
            //使用右移运算符，继续
            result=result>>1;
            k=k>>1;
        }
        return count;
    }
}
