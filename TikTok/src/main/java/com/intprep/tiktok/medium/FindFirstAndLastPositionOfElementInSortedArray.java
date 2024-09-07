package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return revise(nums, target);
    }

    private int[] revise(int[] nums, int target) {
        int first = -1;
        int last = -1;

        first = binarySearchLowest(nums, target);
        if (first == -1) return new int[] {-1, -1};

        last = binarySearchHighest(nums, target);

        return new int[] {first, last};
    }

    private int binarySearchLowest(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        int lowest = -1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) {
                lowest = mid;
                r = mid-1;
            } else if (nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return lowest;
    }

    private int binarySearchHighest(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        int highest = -1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) {
                highest = mid;
                l = mid+1;
            } else if (nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return highest;
    }
}
