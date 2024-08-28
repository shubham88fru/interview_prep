package com.intprep.tiktok.easy;

import java.util.Arrays;

//@link - https://leetcode.com/problems/squares-of-a-sorted-array/description/
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        // return sortOkayish(nums);
        return kindaOptimal(nums);
    }

    //T: O(~N)
    public int[] kindaOptimal(int[] nums) {
        int j = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0) j += 1;
        }

        int k = j + 1;
        int idx = 0;
        int[] ans = new int[nums.length];
        while (j >= 0 && k < nums.length) {
            if (Math.abs(nums[j]) <= nums[k]) {
                ans[idx] = nums[j]*nums[j];
                j -= 1;
                idx += 1;
            } else {
                ans[idx] = nums[k]*nums[k];
                k += 1;
                idx += 1;
            }
        }

        while (j >=0) {
            ans[idx] = nums[j]*nums[j];
            j -= 1;
            idx += 1;
        }

        while (k < nums.length) {
            ans[idx] = nums[k]*nums[k];
            k += 1;
            idx += 1;
        }


        return ans;
    }

    //T: O(nlogn)
    private int[] sortOkayish(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int pos = Math.abs(nums[i]);
            nums[i] = pos*pos;
        }
        Arrays.sort(nums);
        return nums;
    }
}
