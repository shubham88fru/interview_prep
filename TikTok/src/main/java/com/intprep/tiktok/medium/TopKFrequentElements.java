package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//@link - https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        return revise(nums, k);
    }

    private int[] revise(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num: nums) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1, a2) -> a1[1]-a2[1]);
        for (Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new int[]{ entry.getKey(), entry.getValue() });
            } else if (entry.getValue() > minHeap.peek()[1]) {
                minHeap.remove();
                minHeap.add(new int[]{ entry.getKey(), entry.getValue() });
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            ans[i] = minHeap.remove()[0];
            i += 1;
        }

        return ans;
    }
}
