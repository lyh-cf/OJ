package com.算法笔记.数组.n数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *@title Problem20
 *@description todo 15. 三数之和
 *@author LYH
 *@version 1.0
 *@create 2023/12/6 0:05
 */
public class Problem20 {
    List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
          int leftIndex=start,rightIndex=nums.length-1;
          List<List<Integer>>elementPairs=new ArrayList<>();
          while (leftIndex<rightIndex){
              int left=nums[leftIndex],right=nums[rightIndex];
              int sum=nums[leftIndex]+nums[rightIndex];
              if(sum>target){
                  while (leftIndex<rightIndex&&nums[rightIndex]==right)rightIndex--;
              }
              else if(sum<target){
                  while (leftIndex<rightIndex&&nums[leftIndex]==left)leftIndex++;
              }
              else if(sum==target){
                  List<Integer>list=new ArrayList<>();
                  list.add(left);
                  list.add(right);
                  elementPairs.add(list);
                  while (leftIndex<rightIndex&&nums[rightIndex]==right)rightIndex--;
                  while (leftIndex<rightIndex&&nums[leftIndex]==left)leftIndex++;
              }
          }
          return elementPairs;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //数组得排序
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        //穷举 threeSum 的第一个数
        for(int i=0;i<nums.length;i++){
            //注意这里的 start 传入 i+1
            List<List<Integer>>temp=twoSumTarget(nums,i+1, -nums[i]);
            //如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for(List<Integer>list:temp){
                list.add(nums[i]);
                ans.add(list);
            }
            //跳过第一个数重复的情况
            while (i<nums.length-1&&nums[i]==nums[i+1])i++;
        }
        return ans;
    }
}
