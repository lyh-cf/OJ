package com.算法笔记.链表.快慢指针;

import com.算法笔记.ListNode;

/*
 *@title Problem03
 *@description todo 02. 返回倒数第 k 个节点
 *              如何只遍历一次链表就算出倒数第K个节点
 *@author LYH
 *@version 1.0
 *@create 2023/11/10 17:07
 */
public class Problem03 {
    public int kthToLast(ListNode head, int k) {
         ListNode p1=head;
         while(k-->0){
             p1=p1.next;
         }
         ListNode p2=head;
         while (p1!=null){
             p1=p1.next;
             p2=p2.next;
         }
         return p2.val;
    }
}
