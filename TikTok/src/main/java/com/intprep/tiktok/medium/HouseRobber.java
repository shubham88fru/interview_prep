package com.intprep.tiktok.medium;

import java.util.Map;

//@link - https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    public int rob(int[] nums) {
        Integer[][] dp = new Integer[nums.length][2];
        return robMax(nums, 0, 1, dp);
    }

    private int robMax(int[] nums, int curr, int canRob, Integer[][] dp) {
        if (curr >= nums.length) return 0;

        if (dp[curr][canRob] != null) return dp[curr][canRob];

        int rob = 0;
        if (canRob == 1) {
            rob = nums[curr] + robMax(nums, curr+1, 0, dp);
        }

        int dontRob = robMax(nums, curr+1, 1, dp);

        dp[curr][canRob] = Math.max(rob, dontRob);
        return dp[curr][canRob];
    }

    //T: O(N), S: O(N)
    private int maxRob(int currIndex, int[] nums, Map<Integer, Integer> memo) {

        if (currIndex>=nums.length) return 0;

        int key = currIndex;
        if (memo.containsKey(key)) return memo.get(key);

        //If Robber robs the current house, fir 1 ghar chhod ke hi chori kar skta hai.
        int robCurrent = nums[currIndex] + maxRob(currIndex+2, nums, memo);

        //If robber doesn't rob current house, fir agle ghar pe bhi chori kar skta hai.
        int dontRobCurrent = maxRob(currIndex+1, nums, memo);

        //Max of the two choices.
        memo.put(key, Math.max(robCurrent, dontRobCurrent));

        return memo.get(key);
    }
}
