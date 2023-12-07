package com.算法笔记.数组.差分;

/*
 *@title Problem26
 *@description todo 1094. 拼车
 *@author LYH
 *@version 1.0
 *@create 2023/12/7 16:22
 */
public class Problem26 {
    // 差分数组
    private int[] diff;

    public boolean carPooling(int[][] trips, int capacity) {
        diff = new int[1001];
        for (int[] change : trips) {
            //整个题目最需要注意的地方：to = change[2]-1，乘客在 5 位置下车，实际上只在 0-4 间占了位置
            int numPassengers = change[0], from = change[1], to = change[2]-1;
            diff[from]+=numPassengers;
            if(to<diff.length-1)diff[to+1]-=numPassengers;
        }
        int[] result=new int[diff.length];
        result[0]=diff[0];
        if(result[0]>capacity)return false;
        for(int i=1;i<result.length;i++){
            result[i]=result[i-1]+diff[i];
            if(result[i]>capacity)return false;
        }
        return true;
    }
}
