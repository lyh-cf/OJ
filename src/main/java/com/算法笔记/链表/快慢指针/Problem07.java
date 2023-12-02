package com.算法笔记.链表.快慢指针;

import com.算法笔记.ListNode;

/*
 *@title Problem07
 *@description todo 022.环形链表 II
 *@author LYH
 *@version 1.0
 *@create 2023/11/12 12:04
 */
public class Problem07 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }
        if(fast==null||fast.next==null)return null;//无环
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
