package com.算法笔记.链表.虚拟头结点;

import com.算法笔记.ListNode;

/*
 *@title Problem01
 *@description todo 21.合并两个有序链表
 *              使用虚拟头结点
 *@author LYH
 *@version 1.0
 *@create 2023/11/9 21:37
 */
public class Problem01 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            tail.next = p1;
            tail = p1;
            p1 = p1.next;
        }
        while (p2 != null) {
            tail.next = p2;
            tail = p2;
            p2 = p2.next;
        }
        return head.next;
    }
}
