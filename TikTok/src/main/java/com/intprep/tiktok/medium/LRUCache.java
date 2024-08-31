package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;

//@link - https://leetcode.com/problems/lru-cache/
public class LRUCache {
    Map<Integer, DLL> cache;
    DLL head = new DLL(-1, -1);
    DLL tail = new DLL(-1, -1);
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();



        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        moveToFront(key);
        return cache.get(key).val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).val = value;
            moveToFront(key);
        } else {
            if (isFull()) {
                evictLast();
            }
            DLL newNode = new DLL(key, value);
            cache.put(key, newNode);
            insertNode(key);
            size += 1;
        }

    }

    private boolean isFull() {
        return size >= capacity;
    }

    private void insertNode(int key) {
        DLL node = cache.get(key);
        node.prev = head;
        head.next.prev = node;
        node.next = head.next;
        head.next = node;

        moveToFront(key);
    }

    private void moveToFront(int key) {
        DLL node = cache.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void evictLast() {
        DLL lastNode = head.next;
        head.next = lastNode.next;
        lastNode.next.prev = head;
        lastNode.next = null;
        lastNode.prev = null;

        cache.remove(lastNode.key);
        size -= 1;
    }
}


class DLL {
    DLL next;
    DLL prev;
    int val;
    int key;

    public DLL(int key, int val) {
        this.key = key;
        this.val = val;
    }
}