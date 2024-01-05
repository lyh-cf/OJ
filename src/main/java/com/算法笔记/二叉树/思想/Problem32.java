package com.算法笔记.二叉树.思想;

import com.算法笔记.二叉树.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *@title Problem32
 *@description todo 116. 填充每个节点的下一个右侧节点指针
 *@author LYH
 *@version 1.0
 *@create 2023/12/28 9:47
 */
public class Problem32 {
    public Node connect(Node root) {
        traverse(root);
        return root;
    }
    void traverse(Node root){
        if(root==null)return;
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node node=queue.poll();
                if(i==n-1)node.next=null;
                else node.next=queue.peek();
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }
    }
}
