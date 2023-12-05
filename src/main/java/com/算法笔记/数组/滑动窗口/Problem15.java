package com.算法笔记.数组.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/*
 *@title Problem15
 *@description todo 567. 字符串的排列
 *@author LYH
 *@version 1.0
 *@create 2023/12/4 21:34
 */
public class Problem15 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            //如果 Map 中存在该键，则返回与该键相关联的值；否则，返回一个默认值。
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left=0,right = 0;
        int value = 0;
        while (right < s2.length()) {
            //将移入窗口的字符
            char rightChar = s2.charAt(right);
            //增大窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                //注意 等于 作为条件，而非 >
                if (window.get(rightChar).equals(need.get(rightChar))) value++;
            }
            //注意这里判断窗口是否收缩的条件，实际上是固定了窗口的大小
            while (right-left==s1.length()){
                if (value == need.size()) {
                    return true;
                }
                //将移出窗口的字符
                char leftChar = s2.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) value--;
                    window.put(leftChar, window.get(leftChar) - 1);
                }
                //缩小窗口
                left++;
            }
        }
        return false;
    }
}
