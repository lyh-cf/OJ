package com.算法笔记.数据结构设计.LRU;

import java.util.LinkedHashMap;

/*
 *@title LRUCache
 *@description todo 146.LRU缓存
 *@author LYH
 *@version 1.0
 *@create 2023/12/8 15:53
 */
public class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        //将key变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            //修改 key 的值
            cache.put(key, value);
            //将 key 变为最近使用
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap) {
            //链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //将新的key添加到链表的尾部
        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        //删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}
