package com.算法笔记.双周赛.T121;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *@title Problem01
 *@description todo 100157. 大于等于顺序前缀和的最小缺失整数
 *@author LYH
 *@version 1.0
 *@create 2024/1/6 22:32
 */
public class Problem01 {
    public int missingInteger(int[] nums) {
        Set<Integer>set=new HashSet<>();
         int sum=nums[0];
         boolean flag=true;
         set.add(nums[0]);
         for(int i=1;i<nums.length;i++){
             if(flag&&nums[i]-1==nums[i-1]){
                 sum+=nums[i];
             }
             else flag=false;
             set.add(nums[i]);
         }
         while (set.contains(sum)){
             sum++;
         }
         return sum;
    }
}
