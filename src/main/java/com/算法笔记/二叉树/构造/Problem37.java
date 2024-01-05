package com.算法笔记.二叉树.构造;

import com.算法笔记.二叉树.TreeNode;

import java.util.HashMap;

/*
 *@title Problem37
 *@description todo 889. 根据前序和后序遍历构造二叉树
 *@author LYH
 *@version 1.0
 *@create 2023/12/29 21:27
 */
public class Problem37 {
    private HashMap<Integer,Integer>hashMap=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
         //维护 值 到 索引 的映射
         for(int i=0;i<postorder.length;i++)hashMap.put(postorder[i],i);
         return construct(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode construct(int[] preorder,int preStart,int preEnd, int[] postorder,int postStart,int postEnd){
         if(preStart>preEnd)return null;
         if(preStart==preEnd)return new TreeNode(preorder[preStart]);
         TreeNode root=new TreeNode(preorder[preStart]);
         int index=hashMap.get(preorder[preStart+1]);
         TreeNode leftNode=construct(preorder,preStart+1,preStart+(index-postStart+1),postorder,postStart,index);
         TreeNode rightNode=construct(preorder,preStart+(index-postStart+1)+1,preEnd,postorder,index+1,postEnd-1);
         root.left=leftNode;
         root.right=rightNode;
         return root;
    }
}
