package com.算法笔记.数组;

/*
 *@title Problem22
 *@description todo 5. 最长回文子串
 *@author LYH
 *@version 1.0
 *@create 2023/12/6 15:38
 */
public class Problem22 {
    String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            //双指针，从中心向两端扩散
            left--;
            right++;
        }
        //因为 left、right此时不满足循环条件
        // 所以注意 闭区间 应该取 left+1; 开区间 应该取 right
        return s.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            ans = ans.length() < s1.length() ? s1 : ans;
            ans = ans.length() < s2.length() ? s2 : ans;
        }
        return ans;
    }
}
