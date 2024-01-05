package com.算法笔记.二叉树.构造;

import com.算法笔记.二叉树.TreeNode;

import java.util.HashMap;

/*
 *@title Problem35
 *@description todo 105. 从前序与中序遍历序列构造二叉树
 *@author LYH
 *@version 1.0
 *@create 2023/12/28 19:48
 */
public class Problem35 {
    private HashMap<Integer,Integer>hashMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //存储inorder中值到索引的映射
        for(int i=0;i<inorder.length;i++)hashMap.put(inorder[i],i);
        return construct(preorder,0,preorder.length-1,inorder,0, preorder.length-1);
    }
    public TreeNode construct(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd){
        if(preStart>preEnd)return null;
        TreeNode root=new TreeNode(preorder[preStart]);
        int index=hashMap.get(preorder[preStart]);
//        for(int i=inStart;i<=inEnd;i++){
//            if(inorder[i]==preorder[preStart]){
//                index=i;
//                break;
//            }
//        }
        TreeNode leftNode=construct(preorder,preStart+1,(preStart+1)+(index-inStart)-1,inorder,inStart,index-1);
        TreeNode rightNode=construct(preorder,(preStart+1)+(index-inStart),preEnd,inorder,index+1,inEnd);
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }
}
