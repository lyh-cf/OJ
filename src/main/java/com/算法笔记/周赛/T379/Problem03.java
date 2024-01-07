package com.算法笔记.周赛.T379;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 *@title Problem03
 *@description todo 100150. 移除后集合的最多元素数
 *@author LYH
 *@version 1.0
 *@create 2024/1/7 10:29
 */
public class Problem03 {
    public  int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
            set2.add(nums2[i]);
        }
        int size1 = set1.size(), size2 = set2.size();
        int same = 0;
        for (int num : set1) {
            if (set2.contains(num)) same++;
        }
        //todo 去掉重复元素后，离变成 nums1.length/2 还要删多少个元素
        int n1 = size1 - nums1.length / 2, n2 = size2 - nums2.length / 2;
        int ans = size1 + size2 - same;
        // 重合的是安全的删除次数，直接减掉
        if (n1 > 0) {
            same -= n1;
        }
        if (n2 > 0) {
            same -= n2;
        }
        // 答案 |s1| + |s2| - overlap
        // 看看迫不得己要删除多少个元素，如果overlap > 0，重合的元素我们也不能要
        return ans + (same > 0 ? 0 : same);
    }
}
