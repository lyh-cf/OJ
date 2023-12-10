package com.算法笔记.数据结构设计.LRU;

import java.util.HashMap;

/*
 *@title LRUCache
 *@description
 *@author LYH
 *@version 1.0
 *@create 2023/12/8 15:03
 */
public class LRUCacheBySelf {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    //最大容量
    private int cap;

    public LRUCacheBySelf(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /* 将某个key提升为最近使用的 */
    public void makeRecently(int key) {
        Node x = map.get(key);
        //先从链表中删除这个节点
        cache.remove(x);
        //重新查到对位
        cache.addLast(x);
    }

    /* 添加最近使用的元素 */
    public void addRecently(int key, int val) {
        Node x = new Node(key, val);
        //链表尾部就是最近使用的元素
        cache.addLast(x);
        map.put(key, x);
    }
    /* 删除某一个 key */
    public void deleteKey(int key){
        Node x=map.get(key);
        //从链表中删除
        cache.remove(x);
        //从 map 中删除
        map.remove(key);
    }
    /* 删除最久未使用的元素 */
    public void removeLeastRecently(){
        //链表头部的第一个元素就是最久未使用的
        Node deleteNode=cache.removeFirst();
        int deletedKey=deleteNode.key;
        map.remove(deletedKey);
    }
}
