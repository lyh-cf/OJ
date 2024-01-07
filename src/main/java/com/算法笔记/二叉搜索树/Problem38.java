package com.算法笔记.二叉搜索树;

import com.算法笔记.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 *@title Problem38
 *@description todo 230. 二叉搜索树中第K小的元素
 *@author LYH
 *@version 1.0
 *@create 2024/1/5 15:58
 */
public class Problem38 {
    private int count=0;
    private int kthSmallest=0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return kthSmallest;
    }
    void traverse(TreeNode root,int k){
        if(root==null)return;

        traverse(root.left,k);
        count++;
        if(count==k){
            kthSmallest=root.val;
            return;
        }

        traverse(root.right,k);
    }
}
