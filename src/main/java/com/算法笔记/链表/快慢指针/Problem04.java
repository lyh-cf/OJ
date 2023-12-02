package com.算法笔记.链表.快慢指针;

import com.算法笔记.ListNode;

/*
 *@title Problem04
 *@description todo 19.删除链表的倒数第 N 个结点
 *@author LYH
 *@version 1.0
 *@create 2023/11/12 10:17
 */
public class Problem04 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //题目说了head一定不为null，即链表最少存在一个元素
        ListNode hair = new ListNode();
        hair.next = head;
        //要删除倒数第n个，要先找到倒数第n+1个节点
        ListNode pre=findFromEnd(hair,n+1);//todo 倒数是从右往左数，虚拟头节点是在最左边添加的，不影响倒数计数
        pre.next=pre.next.next;
        return hair.next;
    }
    public ListNode findFromEnd(ListNode head,  int k) {
        ListNode p1=head;
        while(k-->0){
            p1=p1.next;
        }
        ListNode p2=head;
        while (p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
}
