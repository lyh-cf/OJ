package com.算法笔记.二叉树;

/*
 *@title TreeNode
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/27 15:56
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}