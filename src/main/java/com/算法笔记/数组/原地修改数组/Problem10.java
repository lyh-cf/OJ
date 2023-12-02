package com.算法笔记.数组.原地修改数组;

import com.算法笔记.ListNode;

/*
 *@title Problem10
 *@description todo 83. 删除排序链表中的重复元素
 *@author LYH
 *@version 1.0
 *@create 2023/12/2 17:33
 */
public class Problem10 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode slow=head,fast=head;
        while (fast!=null){
            if(slow.val!=fast.val){
                slow.next=fast;
                slow=fast;
            }
            fast=fast.next;
        }
        //断开与后面重复元素的连接
        //否则输入[1,1,2,3,3]，会输出[1,2,3,3]
        slow.next=null;
        return head;
    }
}
