package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int l = 0;
        int r = numbers.length-1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) return new int[]{ l+1, r+1 };
            if (numbers[l] + numbers[r] < target) {
                l += 1;
            } else r -= 1;
        }

        return null;
    }
}
