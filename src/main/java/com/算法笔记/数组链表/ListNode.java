package com.算法笔记.数组链表;

/*
 *@title ListNode
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/11/10 16:51
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}