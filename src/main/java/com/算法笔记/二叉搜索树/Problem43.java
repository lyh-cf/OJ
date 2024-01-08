package com.算法笔记.二叉搜索树;

import com.算法笔记.二叉树.TreeNode;

/*
 *@title Problem43
 *@description todo 450. 删除二叉搜索树中的节点
 *@author LYH
 *@version 1.0
 *@create 2024/1/8 19:50
 */
public class Problem43 {
    public TreeNode deleteNode(TreeNode root, int key) {
         if(root==null)return null;
         if(root.val<key)root.right=deleteNode(root.right,key);
         if(root.val>key)root.left=deleteNode(root.left,key);
         if(root.val==key){
             //处理情况 1 和 2
             if(root.left==null)return root.right;
             if(root.right==null)return root.left;
             //处理情况 3
             TreeNode minNode=getMin(root.right);
             //删除 右子树的最小节点
             root.right=deleteNode(root.right,minNode.val);
             //用右子树的最小节点替换 root 节点
             minNode.left=root.left;
             minNode.right=root.right;
             //注意
             root=minNode;
         }
         return root;
    }
    public TreeNode getMin(TreeNode root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
}
