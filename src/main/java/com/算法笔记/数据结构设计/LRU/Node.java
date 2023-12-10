package com.算法笔记.数据结构设计.LRU;

/*
 *@title Node
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/8 14:20
 */
public class Node {
    public int key,val;
    public Node next,prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
