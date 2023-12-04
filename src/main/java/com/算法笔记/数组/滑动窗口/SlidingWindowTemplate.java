package com.算法笔记.数组.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/*
 *@title SlidingWindowTemplate
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/4 22:10
 */
public class SlidingWindowTemplate {
    void slidingWindow(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            //将移入窗口的字符
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            //增大窗口
            right++;
            //进行窗口内数据的一系列更新
            //...
            //System.out.println("left："+left+", right："+right); debug

            //判断左侧窗口是否要收缩
            while (left < right && check()) {
                //将移出窗口的字符
                char leftChar = s.charAt(left);
                window.remove(leftChar);
                //缩小窗口
                left++;
                //进行窗口内数据的一系列更新
                //...
            }
        }
    }

    private boolean check() {
    }
}
