package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/maximum-product-subarray/submissions/1183563231/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i=1; i<nums.length; i++) {
            int curr = nums[i];
            int tempMaxSoFar = Math.max(curr, Math.max(maxSoFar*curr, minSoFar*curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar*curr, minSoFar*curr));
            maxSoFar = tempMaxSoFar;

            result = Math.max(maxSoFar, result);
        }

        return result;
    }
}
