package com.算法笔记.二叉搜索树;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem42
 *@description todo 701. 二叉搜索树中的插入操作
 *@author LYH
 *@version 1.0
 *@create 2024/1/8 19:30
 */
public class Problem42 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
        if(root.val<val)root.right=insertIntoBST(root.right,val);
        if(root.val>val)root.left=insertIntoBST(root.left,val);
        return root;
    }
}
