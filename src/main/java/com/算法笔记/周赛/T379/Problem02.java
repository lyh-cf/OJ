package com.算法笔记.周赛.T379;

/*
 *@title Problem02
 *@description todo 100187. 捕获黑皇后需要的最少移动次数
 *@author LYH
 *@version 1.0
 *@create 2024/1/7 10:29
 */
public class Problem02 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
         //象
         if(c-e==d-f){
             if(c-a!=d-b)return 1;
             else if(a<Math.min(c,e)||a>Math.max(c,e))return 1;
             return 2;
         }
         if(c+d==e+f){
             if(c+d!=a+b)return 1;
             else if(a<Math.min(c,e)||a>Math.max(c,e))return 1;
             return 2;
         }
         if(a==e){
             if(c!=a)return 1;
             else if(d < Math.min(b, f) || d > Math.max(b, f))return 1;
             return 2;
         }
         if(b==f){
             if(b!=d)return 1;
             else if(c < Math.min(a, e) || c > Math.max(a, e))return 1;
             return 2;
         }
         return 2;
    }

}
//输入：(1,1) (1,4) (1,8)
//输出：
//1
//预期：
//2

//输入：(4,3) (3,4) (2,5)
//输出：
//2
//预期：
//1