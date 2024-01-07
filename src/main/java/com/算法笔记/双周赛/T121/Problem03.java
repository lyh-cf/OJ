package com.算法笔记.双周赛.T121;

/*
 *@title Problem03
 *@description todo 100159. 使 X 和 Y 相等的最少操作次数
 *@author LYH
 *@version 1.0
 *@create 2024/1/6 22:45
 */
public class Problem03 {
    private int min = Integer.MAX_VALUE;
    public int minimumOperationsToMakeEqual(int x, int y) {
        dfs(x, y, 0);
        return min;
    }
    public void dfs(int x, int y, int count) {
        if (count >= min) return;
        if (x == y) {
            min = Math.min(min, count);
            return;
        }
        //todo
        min=Math.min(min,count+Math.abs(x-y));
        if (x > y) {
            //+
            dfs(x/11+1,y,count+(11-x%11)+1);
            dfs(x/5+1,y,count+(5-x%5)+1);
            //-
            dfs(x/11,y,count+(x%11)+1);
            dfs(x/5,y,count+(x%5)+1);
        }
        if (x < y) dfs(x + 1, y, count+1);
    }
}