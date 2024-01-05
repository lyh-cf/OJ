package com.算法笔记.二叉树.两种解题思路;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem27
 *@description todo 104. 二叉树的最大深度
 *@author LYH
 *@version 1.0
 *@create 2023/12/27 15:51
 */
public class Problem27method1 {
//    private int depth=0;
    private int maxDepth=0;
    public int maxDepth(TreeNode root) {
         traverse(root,1);
         return maxDepth;
    }
    void traverse(TreeNode root,int depth){
        //递归出口，到达叶子结点
        if(root==null){
            maxDepth=Math.max(depth-1,maxDepth);
            return;
        }
        traverse(root.left,depth+1);
        traverse(root.right,depth+1);
    }
//    void traverse(TreeNode root){
//        //递归出口，到达叶子结点
//        if(root==null){
//            maxDepth=Math.max(depth,maxDepth);
//            return;
//        }
//        //前序位置
//        depth++;
//        traverse(root.left);
//        traverse(root.right);
//        //后序位置
//        depth--;
//    }
}
