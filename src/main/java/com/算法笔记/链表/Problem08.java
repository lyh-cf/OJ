package com.算法笔记.链表;

import com.算法笔记.ListNode;

/*
 *@title Problem08
 *@description todo 160. 相交链表
 *@author LYH
 *@version 1.0
 *@create 2023/11/19 21:56
 */
public class Problem08 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode p1=headA,p2=headB;
         while (p1!=p2){
             p1=p1==null?headB:p1.next;
             p2=p2==null?headA:p2.next;
         }
         return p1;
    }
}
