package com.算法笔记.数组.滑动窗口;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 *@title Problem14
 *@description todo 76. 最小覆盖子串
 *@author LYH
 *@version 1.0
 *@create 2023/12/4 17:18
 */
public class Problem14 {
    public static void main(String[] args) {
//        String s = "aabb", t = "ab";
//        System.out.println(minWindow(s, t));
    }

    String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            //如果 Map 中存在该键，则返回与该键相关联的值；否则，返回一个默认值。
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int value = 0;
        int start = 0, length = Integer.MAX_VALUE;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                //注意 等于 作为条件，而非 >
                if (window.get(rightChar).equals(need.get(rightChar))) value++;
            }
            while (value == need.size()) {
                char leftChar = s.charAt(left);
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) value--;
                    if (window.containsKey(leftChar) && window.get(leftChar) == 1) window.remove(leftChar);
                    else if (window.containsKey(leftChar)) window.put(leftChar, window.get(leftChar) - 1);
                }
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
