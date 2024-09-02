package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;

//@link - https://leetcode.com/problems/greatest-sum-divisible-by-three/
public class GreatestSumDivisibleBy3 {
    public int maxSumDivThree(int[] nums) {
        return dp(nums, 0, 0, new HashMap<>());
    }

    private int dp(int[] nums, int curr, int sum, Map<String, Integer> memo) {
        if (curr >= nums.length) {
            if (sum%3 == 0) return 0;
            return -10000000;
        }

        String key = curr + "_" + (sum%3); //trick, use %3 as key. Using simple sum would give TLE. See history.
        if (memo.containsKey(key)) return memo.get(key);

        int pick = nums[curr] + dp(nums, curr+1, sum+nums[curr], memo);
        int notPick = dp(nums, curr+1, sum, memo);

        memo.put(key, Math.max(pick, notPick));
        return memo.get(key);
    }
}
