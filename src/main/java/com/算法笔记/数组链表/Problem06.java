package com.算法笔记.数组链表;

/*
 *@title Problem06
 *@description todo 141.环形链表
 *@author LYH
 *@version 1.0
 *@create 2023/11/12 11:58
 */
public class Problem06 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            //快慢指针相遇，说明有环
            if(slow==fast)return true;
        }
        return false;
    }
}
