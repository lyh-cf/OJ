package com.算法笔记.数组.n数之和;

import java.util.*;

/*
 *@title Problem19
 *@description todo 2Sum问题（自定义问题）
 *@author LYH
 *@version 1.0
 *@create 2023/12/5 20:09
 */
/*
假如输入一个数组 nums 和一个目标和 target，请你返回 nums 中能够凑出 target 的两个元素的值，
比如输入 nums=[1,3,5,6]，target=9，那么算法返回两个元素[3,6]。
并且nums中可能有多对元素之和都等于target，要求返回的元素对中不能出现重复。
 */
public class Problem19 {
    List<List<Integer>> twoSumTarget(List<Integer> nums, int target) {
        //排序
        Collections.sort(nums);
        int leftIndex = 0, rightIndex = nums.size() - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (leftIndex < rightIndex) {
            int sum = nums.get(leftIndex) + nums.get(rightIndex);
            int left = nums.get(leftIndex), right = nums.get(rightIndex);
            if (sum < target) {
                while (leftIndex < rightIndex && nums.get(leftIndex) == left) leftIndex++;
            } else if (sum > target) {
                while (leftIndex < rightIndex && nums.get(rightIndex) == right) rightIndex--;
            } else if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                ans.add(list);
                //两数之和
                while (leftIndex < rightIndex && nums.get(leftIndex) == left) leftIndex++;
                while (leftIndex < rightIndex && nums.get(rightIndex) == right) rightIndex--;
            }
        }
        return ans;
    }
}
