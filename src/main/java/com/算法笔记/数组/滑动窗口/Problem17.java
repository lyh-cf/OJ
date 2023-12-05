package com.算法笔记.数组.滑动窗口;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 *@title Problem17
 *@description todo 3. 无重复字符的最长子串
 *@author LYH
 *@version 1.0
 *@create 2023/12/5 14:53
 */
public class Problem17 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = Integer.MIN_VALUE;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            right++;
            // 注意这里的判断条件，非常精妙，而不用每次检索 map 里的每个 key
            while (window.getOrDefault(rightChar, 0) > 1) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }
            if (right - left > maxLength) maxLength = right - left;
        }
        return maxLength;
    }

}
