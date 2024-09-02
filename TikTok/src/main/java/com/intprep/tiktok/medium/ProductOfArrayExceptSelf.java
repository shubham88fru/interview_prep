package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        return revise(nums);
    }

    private int[] revise(int[] nums) {
        int[] pp = new int[nums.length];
        int[] sp = new int[nums.length];

        pp[0] = 1;
        for (int i=1; i<nums.length; i++) {
            pp[i] = nums[i-1]*pp[i-1];
        }

        sp[sp.length-1] = 1;
        for (int i=nums.length-2; i>=0; i--) {
            sp[i] = nums[i+1]*sp[i+1];
        }

        int[] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i==0) ans[i] = sp[0];
            if (i==nums.length-1) ans[i] = pp[nums.length-1];
            ans[i] = sp[i]*pp[i];
        }

        return ans;
    }
}
