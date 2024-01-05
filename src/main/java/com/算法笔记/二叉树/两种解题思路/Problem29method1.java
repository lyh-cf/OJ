package com.算法笔记.二叉树.两种解题思路;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem29
 *@description todo 543. 二叉树的直径
 *@author LYH
 *@version 1.0
 *@create 2023/12/27 20:57
 */
public class Problem29method1 {
    private int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return ans;
    }
    void traverse(TreeNode root){
        if(root==null)return;
        int leftMaxDepth=maxDepth(root.left);
        int rightMaxDepth=maxDepth(root.right);
        ans=Math.max(leftMaxDepth+rightMaxDepth,ans);//这里不需要再+1，因为只是一个点
        traverse(root.left);
        traverse(root.right);
    }
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
