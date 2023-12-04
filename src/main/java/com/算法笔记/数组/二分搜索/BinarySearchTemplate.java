package com.算法笔记.数组.二分搜索;

/*
 *@title BinarySearchTemplate
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/2 22:29
 */
public class BinarySearchTemplate {
    public static void main(String[] args) {
//        int[] nums={1,1,2,2,2,6,7,8,9,10};
//        int index=binarySearch(nums,2);
//        if(index!=-1) System.out.println("元素的索引是：" + index);
//        else System.out.println("未找到元素");
    }
     int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;//注意 right 的值
        while (left<=right){
            //防止 left+right 过大
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;//注意
            }
            else if(nums[mid]>target){
                right=mid-1;//注意
            }
        }
        return -1;
    }
}
