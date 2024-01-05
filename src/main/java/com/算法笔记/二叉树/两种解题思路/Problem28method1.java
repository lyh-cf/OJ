package com.算法笔记.二叉树.两种解题思路;

import com.算法笔记.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 *@title Problem28method1
 *@description todo 144. 二叉树的前序遍历
 *@author LYH
 *@version 1.0
 *@create 2023/12/27 16:27
 */
public class Problem28method1 {
    private List<Integer>ans=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
         preTraversal(root);
         return ans;
    }
    void preTraversal(TreeNode root){
        //递归出口
        if(root==null)return;
        //前序位置
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
