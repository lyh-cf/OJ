package com.算法笔记.数组.前缀和;

/*
 *@title Problem24
 *@description todo 304. 二维区域和检索 - 矩阵不可变
 *@author LYH
 *@version 1.0
 *@create 2023/12/6 16:56
 */
public class Problem24 {
    //定义：preSum[i][j]，记录 matrix 中子矩阵 [0,0,i-1,j-1] 的元素和
    private int[][] preSum;

    public Problem24(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //构造前缀和矩阵
        preSum=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                preSum[i][j]=preSum[i][j-1]+preSum[i-1][j]+matrix[i-1][j-1]-preSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
          return preSum[row2+1][col2+1]-preSum[row2+1][col1]-preSum[row1][col2+1]+preSum[row1][col1];
    }
}
