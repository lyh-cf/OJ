package com.算法笔记.数组.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@title Problem16
 *@description todo 438. 找到字符串中所有字母异位词
 *@author LYH
 *@version 1.0
 *@create 2023/12/5 14:23
 */
public class Problem16 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int value = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < s.length()) {
            //将移入窗口的字符
            char rightChar = s.charAt(right);
            //进行窗口内数据的一系列更新
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (need.get(rightChar).equals(window.get(rightChar))) value++;
            }
            //增大窗口
            right++;
            //判断左侧窗口是否要收缩
            while (right - left == p.length()) {
                if (value == need.size()) ans.add(left);
                //将移出窗口的字符
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) value--;
                    window.put(leftChar, window.get(leftChar) - 1);
                }
                //缩小窗口
                left++;
            }
        }
        return ans;
    }
}
