package com.算法笔记.数组链表;

/*
 *@title Problem05
 *@description todo 876. 链表的中间结点
 *              如何遍历一遍就获取到 链表的中间结点
 *@author LYH
 *@version 1.0
 *@create 2023/11/12 11:13
 */
public class Problem05 {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast==null)return slow;//快慢指针，当中点有两个时，返回的节点是靠后的那个节点
        return slow;
    }
}
