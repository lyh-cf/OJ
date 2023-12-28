package com.算法笔记.二叉树;

/*
 *@title Problem31
 *@description todo 226. 翻转二叉树
 *@author LYH
 *@version 1.0
 *@create 2023/12/28 9:19
 */
public class Problem31 {
    public TreeNode invertTree(TreeNode root) {
          traverse(root);
          return root;
    }
    void traverse(TreeNode root){
        if(root==null)return;
        //思考单独抽出一个二叉树节点，需要对它做什么，需要在什么时候（前、中、后序）做
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        traverse(root.left);
        traverse(root.right);
    }
}
