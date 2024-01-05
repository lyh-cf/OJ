package com.算法笔记.二叉树.序列化;

import com.算法笔记.二叉树.TreeNode;
import com.算法笔记.数据结构设计.LRU.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 *@title Problem38
 *@description todo 297. 二叉树的序列化与反序列化
 *@author LYH
 *@version 1.0
 *@create 2024/1/2 8:22
 */
public class Problem38 {
    //代表分隔符的字符
    private String SEP=",";
    //代表null空指针的字符
    private String NULL="#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder string=new StringBuilder();
        traverse(root,string);
        return string.toString();
    }

    // Decodes your encoded data to tree.
    /* 将字符串转化为列表 */
    public TreeNode deserialize(String data) {
        LinkedList<String>list=new LinkedList<>();
        for(String s:data.split(",")){
            list.add(s);
        }
        return construct(list);
    }
    public TreeNode construct(LinkedList<String>list){
        if(list.isEmpty())return null;
        /* 前序位置 */
        String root=list.removeFirst();
        if(NULL.equals(root))return null;
        TreeNode rootNode=new TreeNode(Integer.valueOf(root));
        rootNode.left=construct(list);
        rootNode.right=construct(list);
        return rootNode;
    }
    /* 将二叉树打平为字符串 */
    public void traverse(TreeNode root,StringBuilder string){
        if(root==null){
            string.append(NULL).append(SEP);
            return;
        }
        /* 前序位置 */
        string.append(root.val).append(SEP);
        traverse(root.left,string);
        traverse(root.right,string);
    }
}
