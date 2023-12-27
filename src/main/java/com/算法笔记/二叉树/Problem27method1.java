package com.算法笔记.二叉树;

/*
 *@title Problem27
 *@description todo 104. 二叉树的最大深度
 *@author LYH
 *@version 1.0
 *@create 2023/12/27 15:51
 */
public class Problem27method1 {
    private int depth=0;
    private int maxDepth=0;
    public int maxDepth(TreeNode root) {
         traverse(root);
         return maxDepth;
    }
    void traverse(TreeNode root){
        //递归出口，到达叶子结点
        if(root==null){
            maxDepth=Math.max(depth,maxDepth);
            return;
        }
        //前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        //后序位置
        depth--;
    }
}
