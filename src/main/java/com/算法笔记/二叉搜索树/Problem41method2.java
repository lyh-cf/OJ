package com.算法笔记.二叉搜索树;
import com.算法笔记.二叉树.TreeNode;
/*
 *@title Problem41method2
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/8 16:09
 */
public class Problem41method2 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return null;
        if(root.val>val)return searchBST(root.left,val);
        if(root.val<val)return searchBST(root.right,val);
        return root;
    }
}
