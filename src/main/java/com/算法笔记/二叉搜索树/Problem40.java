package com.算法笔记.二叉搜索树;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem40
 *@description todo 98. 验证二叉搜索树
 *@author LYH
 *@version 1.0
 *@create 2024/1/8 15:23
 */
public class Problem40 {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    //将 root 的约束条件传给左右子树
    public boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        /*以 root 为根的子树节点必须满足 max.val>root.val>min.val */
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        //isBST(root.left, null, root) && isBST(root.right, root, null);是错误的
        //丢掉了父节点传承下来的min、max
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}
