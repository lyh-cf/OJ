package com.算法笔记.二叉搜索树;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem39
 *@description todo 538. 把二叉搜索树转换为累加树
 *@author LYH
 *@version 1.0
 *@create 2024/1/8 12:35
 */
public class Problem39 {
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
         traverse(root);
         return root;
    }
    void traverse(TreeNode root){
        if(root==null)return;
        //先递归遍历右子树
        traverse(root.right);
        //降序遍历一遍就好了
        sum+=root.val;
        root.val=sum;
        //后递归遍历左子树
        traverse(root.left);
    }
}
