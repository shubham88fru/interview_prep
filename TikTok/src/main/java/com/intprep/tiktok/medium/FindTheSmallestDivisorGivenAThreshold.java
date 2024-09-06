package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num > max) max = num;
        }

        int l = 1;
        int r = max;

        int min = 0;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (divideAndSum(nums, mid) <= threshold) {
                min = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return min;
    }

    private int divideAndSum(int[] nums, int mid) {
        int sum = 0;
        for (int num: nums) {
            sum += (Math.ceil(num/(float)mid));
        }
        return sum;
    }
}
