package com.算法笔记.周赛.T379;

/*
 *@title Problem01
 *@description todo 100170. 对角线最长的矩形的面积
 *@author LYH
 *@version 1.0
 *@create 2024/1/7 10:29
 */
public class Problem01 {
    public static void main(String[] args) {

    }
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxLength=0;
        int maxAns=0;
        for(int[] vis:dimensions){
            if(Math.sqrt(vis[0]*vis[0]+vis[1]*vis[1])>maxLength){
                maxLength=Math.sqrt(vis[0]*vis[0]+vis[1]*vis[1]);
                maxAns=vis[0]*vis[1];
            }
            else if(Math.sqrt(vis[0]*vis[0]+vis[1]*vis[1])==maxLength){
                maxAns=Math.max(maxAns,vis[0]*vis[1]);
            }
        }
        return maxAns;
    }
}
//[[6,5],[8,6],[2,10],[8,1],[9,2],[3,5],[3,5]]
//48
//20