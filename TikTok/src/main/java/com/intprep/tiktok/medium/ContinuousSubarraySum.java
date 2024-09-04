package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;

//@link - https://leetcode.com/problems/continuous-subarray-sum/description/
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        return revise(nums, k);
    }

    private boolean revise(int[] nums, int k) {
        Map<Integer, Integer> pms = new HashMap<>();
        pms.put(0, 0);
        int ms = 0;
        for (int i=1; i<=nums.length; i++) {
            ms = (ms + nums[i-1])%k;
            if (pms.containsKey(ms)) {
                if (i-pms.get(ms) >= 2) return true;
            } else pms.put(ms, i);
        }

        return false;
    }

    private boolean optimal(int[] nums, int k) {
        /**
         In short, the idea to solve this problem is that
         we'll keep a track of prefix sum mod k and if at
         any point we see a prefix sum mod k that was seen before,
         it means that that sum of nums in the range from current
         to previous is divisible by k (coz prefix sum mod k for that range is 0)
         */
        //we'll keep track of prefix sum mod k (instead of simple prefix sum)
        int psumModK = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(psumModK, 0);
        for (int i=0; i<nums.length; i++) {
            psumModK = (psumModK + nums[i])%k; //Note: can't write this eqn as --> psumModK += (nums[i]%k)

            //If at an index, we get a prefix sum (mod k) that was
            //already seen before, it means that the sum (mod k) of
            //numbers between the two indices was certainly zero i.e. divisible
            //by k. Therefore, all we'll have to confirm is that the length of
            //such range is more than two (ATQ).
            if (mp.containsKey(psumModK) && (i+1-mp.get(psumModK) >= 2)) return true;

            //If the we have already seen a prefix sum (mod k), we won't
            //update the map, coz we are anyways interested in finding the
            //largest subarray to know whethere to return true or false.
            if (!mp.containsKey(psumModK)) mp.put(psumModK, i+1); //Note i+1, not i.
        }

        return false;
    }
}
