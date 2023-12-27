package com.算法笔记.二叉树;

/*
 *@title Problem29method02
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/27 22:18
 */
public class Problem29method2 {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        ans = Math.max(maxLeftDepth + maxRightDepth, ans);
        //整棵树的最大深度等于左右子树的最大深度取最大值
        //然后再加上根节点自己
        return 1 + Math.max(maxLeftDepth, maxRightDepth);
    }
}
