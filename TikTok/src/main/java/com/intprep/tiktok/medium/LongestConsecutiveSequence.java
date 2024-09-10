package com.intprep.tiktok.medium;

import java.util.HashSet;
import java.util.Set;

//@link - https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // return revise(nums);
        return reviseBetter(nums);
    }

    private int reviseBetter(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num: nums) st.add(num);

        int maxLen = 0;
        for (int i=0; i<nums.length; i++) {
            if (st.contains(nums[i]-1)) continue;
            int test = nums[i];
            int len = 0;
            while (st.contains(test)) {
                len += 1;
                test += 1;
            }

            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }

    private int revise(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num: nums) st.add(num);

        int maxLen = 0;
        int maxi = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            int test = nums[i];
            int len = 0;
            while (st.contains(test)) {
                len += 1;
                test -= 1;
            }
            if (len > maxLen) {
                maxLen = len;
                maxi = nums[i];
            }


        }

        return maxLen;
    }
}
