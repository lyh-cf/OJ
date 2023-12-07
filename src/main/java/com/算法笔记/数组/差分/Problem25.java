package com.算法笔记.数组.差分;

import java.util.Arrays;

/*
 *@title Problem25
 *@description todo 1109. 航班预订统计
 *@author LYH
 *@version 1.0
 *@create 2023/12/7 16:06
 */
public class Problem25 {
    // 差分数组
    private int[] diff;

    public int[] corpFlightBookings(int[][] bookings, int n) {
        diff=new int[n+1];
        for(int[] change:bookings){
            int i=change[0],j=change[1],value=change[2];
            diff[i]+=value;
            if(j<diff.length-1)diff[j+1]-=value;
        }
        int[] ans=new int[diff.length-1];
        ans[0]=diff[1];
        for(int i=1;i<ans.length;i++){
            ans[i]=ans[i-1]+diff[i+1];
        }
        return ans;
    }
}
