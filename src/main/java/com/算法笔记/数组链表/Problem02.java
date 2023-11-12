package com.算法笔记.数组链表;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 *@title Problem02
 *@description todo 23.合并 K 个升序链表
 *              使用优先队列这种能够自动排序的数据结构，使用虚拟头结点
 *@author LYH
 *@version 1.0
 *@create 2023/11/10 16:41
 */
public class Problem02 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;//第一次判空处理
        ListNode head=new ListNode();
        ListNode tail=head;
        PriorityQueue<ListNode>priorityQueue=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode node:lists){
            if(node!=null)priorityQueue.add(node);//第二次判空处理
        }
        while (!priorityQueue.isEmpty()){
             ListNode minNode=priorityQueue.poll();
             tail.next=minNode;
             tail=minNode;
             if(minNode.next!=null)priorityQueue.add(minNode.next);
        }
        return head.next;
    }
}
