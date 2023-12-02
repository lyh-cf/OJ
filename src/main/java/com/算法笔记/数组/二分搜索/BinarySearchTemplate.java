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
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        binarySearch(nums,2);
    }
    static void binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        int searchCount=0;
        while (left<=right){
            //防止 left+right 过大
            int mid=left+(right-left)/2;
            searchCount++;
            if(nums[mid]==target){
                System.out.println("查找 "+searchCount+" 次找到了");
                break;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
        }
    }
}
