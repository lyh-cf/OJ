package com.算法笔记.排序;

import java.util.Arrays;

/*
 *@title QuickSort
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/26 21:00
 */
public class QuickSort {
    public static void quickSort(int[] vis,int left,int right){
        //递归出口,不然会无限递归
        if(left>right)return;
        int standard=vis[left];
        int i=left,j=right;
        while(i<j){
            while (vis[j]>=standard&&i<j)j--;
            while (vis[i]<=standard&&i<j)i++;
            if(i<j){
                int temp=vis[i];
                vis[i]=vis[j];
                vis[j]=temp;
            }
        }
        int temp=vis[i];
        vis[i]=vis[left];
        vis[left]=temp;
        quickSort(vis,left,i-1);//继续处理左边的
        quickSort(vis,i+1,right);//继续处理右边的
    }
    public static void main(String[] args) {
        int[] vis=new int[]{9,8,7,6,5,4,3,2,1,0};
        quickSort(vis,0,vis.length-1);
        System.out.println(Arrays.toString(vis));
    }
}
