package com.算法笔记.二叉树.构造;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem34
 *@description todo 654. 最大二叉树
 *@author LYH
 *@version 1.0
 *@create 2023/12/28 19:05
 */
public class Problem34 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
          int n=nums.length;
          return construct(0,n-1,nums);
    }
    public TreeNode construct(int left,int right,int[]nums){
        if(left>right)return null;
        int max=Integer.MIN_VALUE;
        int index=0;
        for(int i=left;i<=right;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        TreeNode leftNode=construct(left,index-1,nums);
        TreeNode rightNode=construct(index+1,right,nums);
        //后续位置
        //思考单独抽出一个二叉树节点，需要对它做什么，需要在什么时候（前、中、后序）做
        TreeNode node=new TreeNode(max);
        node.left=leftNode;
        node.right=rightNode;
        return node;
    }
}
