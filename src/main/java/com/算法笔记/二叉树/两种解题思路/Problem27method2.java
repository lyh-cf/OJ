package com.算法笔记.二叉树.两种解题思路;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem27method2
 *@description todo 104. 二叉树的最大深度
 *@author LYH
 *@version 1.0
 *@create 2023/12/27 16:05
 */
public class Problem27method2 {
    public int maxDepth(TreeNode root) {
        //递归出口
        if(root==null)return 0;
        //计算左右子树的最大深度
        int leftMax=maxDepth(root.left);
        int rightMax=maxDepth(root.right);
        //整棵树的最大深度等于左右子树的最大深度取最大值
        //然后再加上根节点自己
        return Math.max(leftMax,rightMax)+1;
    }
}
