package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//@link - https://leetcode.com/problems/smallest-string-with-swaps/
//@check - https://www.youtube.com/watch?v=O3jr8HOpkUU
public class SmallestStringWithSwap {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        /** Understood at a high level. But implmentation is entirely @copypasta */
        char[] str = s.toCharArray();

        //<ParentID, All character that map to the same parent>
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        UnionFind uf = new UnionFind(str.length);

        for (List<Integer> pair: pairs) {
            uf.unify(pair.get(0), pair.get(1));
        }

        for (int i=0; i<str.length; i++) {
            int parentId = uf.getAbsoluteParent(i);
            PriorityQueue<Character> pq = map.getOrDefault(parentId, new PriorityQueue<Character>());
            pq.offer(str[i]);
            map.putIfAbsent(parentId, pq);
        }

        for (int i=0; i<str.length; i++) {
            int parentId = uf.getAbsoluteParent(i);
            str[i] = map.get(parentId).poll();
        }

        return new String(str);
    }
}

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int getAbsoluteParent(int i) {
        if (parent[i] == i) return i;
        parent[i] = getAbsoluteParent(parent[i]);
        return parent[i];
    }

    public void unify(int i, int j) {
        int absoluteParentI = getAbsoluteParent(i);
        int absoluteParentJ = getAbsoluteParent(j);
        if (absoluteParentI != absoluteParentJ) {
            parent[absoluteParentJ] = absoluteParentI;
        }
    }
}