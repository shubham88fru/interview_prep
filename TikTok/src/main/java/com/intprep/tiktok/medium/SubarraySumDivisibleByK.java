package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;

//@link - https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
public class SubarraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        return revise(nums, k);
    }

    private int revise(int[] nums, int k) {
        Map<Integer, Integer> psMap = new HashMap<>();

        int count = 0;
        int pms = 0;
        psMap.put(0, 1);
        for (int i=1; i<=nums.length; i++) {
            pms = ((((pms + nums[i-1])%k)+k)%k);
            if (psMap.containsKey(pms)) {
                count += psMap.get(pms);
            }
            psMap.put(pms, psMap.getOrDefault(pms, 0)+1);
        }

        return count;
    }
}
