package com.算法笔记.数组;

/*
 *@title Problem21
 *@description todo 344. 反转字符串
 *@author LYH
 *@version 1.0
 *@create 2023/12/6 15:16
 */
public class Problem21 {
    public void reverseString(char[] s) {
        int left=0,right=s.length-1;
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
