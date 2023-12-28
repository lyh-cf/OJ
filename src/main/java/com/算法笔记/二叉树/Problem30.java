package com.算法笔记.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *@title Problem30
 *@description todo 102. 二叉树的层序遍历
 *@author LYH
 *@version 1.0
 *@create 2023/12/28 8:56
 */
public class Problem30 {
    public List<List<Integer>> levelOrder(TreeNode root) {
           List<List<Integer>>ans=new ArrayList<>();
           if(root==null)return ans;
           Queue<TreeNode>queue=new LinkedList<>();
           queue.add(root);
           while(!queue.isEmpty()){
               int n=queue.size();
               List<Integer>list=new ArrayList<>();
               for(int i=0;i<n;i++){
                   TreeNode node=queue.poll();
                   if(node.left!=null)queue.add(node.left);
                   if(node.right!=null)queue.add(node.right);
                   list.add(node.val);
               }
               ans.add(list);
           }
           return ans;
    }
}
