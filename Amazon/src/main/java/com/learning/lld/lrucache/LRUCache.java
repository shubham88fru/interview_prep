package com.learning.lld.lrucache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private DLL head;
    private DLL tail;
    private Map<Integer, DLL> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new DLL(-1, -1);
        tail = new DLL(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        DLL node = cache.get(key);

        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLL node = null;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
        } else {
            if (cache.size() == capacity) {
                removeLRU();
            }
            node = new DLL(key, value);
            cache.put(key, node);
        }

        moveToFront(node);
    }

    private void moveToFront(DLL node) {
        DLL prev = node.prev;
        DLL next = node.next;

        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = prev;
        }

        DLL currMRU = head.next;
        node.prev = head;
        head.next = node;
        node.next = currMRU;
        currMRU.prev = node;
    }

    private void removeLRU() {
        DLL currLRU = tail.prev;
        currLRU.prev.next = tail;
        tail.prev = currLRU.prev;

        cache.remove(currLRU.key);
    }
}

class DLL {
    DLL next;
    DLL prev;
    int key;
    int value;

    public DLL(int key, int value) {
        this.value = value;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */