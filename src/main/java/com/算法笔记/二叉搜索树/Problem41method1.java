package com.算法笔记.二叉搜索树;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem41
 *@description todo 700. 二叉搜索树中的搜索
 *@author LYH
 *@version 1.0
 *@create 2024/1/8 15:50
 */
public class Problem41method1 {
    private TreeNode searchNode = null;
    public TreeNode searchBST(TreeNode root, int val) {
        traverse(root, val);
        return searchNode;
    }
    void traverse(TreeNode root, int val) {
        if (root == null) return;
        if (root.val == val) searchNode = root;
        else if (root.val > val) searchBST(root.left, val);
        else searchBST(root.right, val);
    }
}
