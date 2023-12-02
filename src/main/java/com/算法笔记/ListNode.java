package com.算法笔记;

/*
 *@title ListNode
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/11/10 16:51
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}