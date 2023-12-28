package com.算法笔记.二叉树;

/*
 *@title Node
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/28 9:46
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};