package com.算法笔记.二叉树.构造;

import com.算法笔记.二叉树.TreeNode;

import java.util.HashMap;

/*
 *@title Problem36
 *@description todo 106. 从中序与后序遍历序列构造二叉树
 *@author LYH
 *@version 1.0
 *@create 2023/12/28 20:38
 */
public class Problem36 {
    private HashMap<Integer,Integer>hashMap=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //存储inorder中值到索引的映射
        for(int i=0;i<inorder.length;i++)hashMap.put(inorder[i],i);
        return construct(inorder,0,inorder.length-1,postorder,0, postorder.length-1);
    }
    public TreeNode construct(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd){
        if(inStart>inEnd)return null;
        TreeNode root= new TreeNode(postorder[postEnd]);
        int index=hashMap.get(postorder[postEnd]);
        TreeNode leftNode=construct(inorder,inStart,index-1,postorder,postStart,postStart+(index-inStart)-1);
        //这里postEnd要传 postEnd-1
        TreeNode rightNode=construct(inorder,index+1,inEnd,postorder,postStart+(index-inStart),postEnd-1);
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }
}
