package com.intprep.tiktok.easy;

import java.util.HashMap;
import java.util.Map;

//@link - https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (mp.containsKey(target-nums[i])) return new int[] {i, mp.get(target-nums[i])};
            else mp.put(nums[i], i);
        }

        return null;
    }
}
