package com.算法笔记.二叉树.两种解题思路;

import com.算法笔记.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 *@title Problem28method2
 *@description todo 144. 二叉树的前序遍历
 *@author LYH
 *@version 1.0
 *@create 2023/12/27 16:27
 */
public class Problem28method2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null)return list;
        list.add(root.val);
        if(root.left!=null)list.addAll(preorderTraversal(root.left));
        if(root.right!=null)list.addAll(preorderTraversal(root.right));
        return list;
    }
}
