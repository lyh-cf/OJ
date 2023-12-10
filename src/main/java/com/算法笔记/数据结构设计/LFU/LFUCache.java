package com.算法笔记.数据结构设计.LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;

/*
 *@title LFUCache
 *@description todo 460.LFU缓存
 *@author LYH
 *@version 1.0
 *@create 2023/12/9 15:46
 */
public class LFUCache {
    //key到val的映射
    HashMap<Integer, Integer> keyToVal;
    //key 到 freq(访问频次) 的映射
    HashMap<Integer, Integer> keyToFreq;
    //freq 到 key 列表的映射
    HashMap<Integer, LinkedHashSet<Integer>> freqTokeys;
    //记录最小的频次
    int minFreq;
    //记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqTokeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        //增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        //将 key 从 freq 对应的列表中删除
        freqTokeys.get(freq).remove(key);
        //将 key 加入 freq+1 对应的列表中
        freqTokeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqTokeys.get(freq + 1).add(key);
        //如果 freq 对应的列表空了，移除这个 freq
        if (freqTokeys.get(freq).isEmpty()) {
            freqTokeys.remove(freq);
            //如果这个 freq 恰好是 minFreq，更新 minFreq
            //todo 这里需要更新，并且能在 O(1) 时间复杂度更新
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    public void put(int key, int value) {
        /*若 key 已存在，修改对应的 val 即可*/
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            //key 对应的 freq +1
            increaseFreq(key);
            return;
        }
        /*key 不存在，需要插入*/
        /*容量已满的话需要淘汰一个 freq 最小的 key*/
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }
        keyToVal.put(key, value);
        //putIfAbsent() 方法会先判断指定的键（key）是否存在，不存在则将键/值对插入到 HashMap 中
        keyToFreq.put(key, 1);
        freqTokeys.putIfAbsent(1, new LinkedHashSet<>());
        freqTokeys.get(1).add(key);
        //插入新 key 后最小的 freq 肯定是 1
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        //freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqTokeys.get(this.minFreq);
        //其中最先被插入的那个 key 就是应该被淘汰的 key
        int deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqTokeys.remove(this.minFreq);
            //todo 这里不需要更新 minFreq 的值，put 方法调用时一定会将 minFreq 更新为 1
        }
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }
}
