package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/find-peak-element/
public class PeakElement {
    public int findPeakElement(int[] nums) {
        // return revise(nums);
        return binarySearch(nums);
    }

    //TC: O(logn)
    //@check - https://www.youtube.com/watch?v=cXxmbemS6XM&t=1427s&ab_channel=takeUforward
    private int binarySearch(int[] nums) {
        //edge cases.

        //just one element
        if (nums.length == 1) return 0;

        //If leftmost or rightmost elements
        //are peak, no need to perform binary search.
        //Checking this here itself is important coz,
        //then we'll shrink our binary search at the begining
        //only to the inner elements and we won't have to
        //worry about the indexes going out of bounds during
        //binary search.
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;

        //since the element and 0 and nums.length-1 are
        //already checked to be peak or not,
        //we'll perform binary search only on the inner elements.
        int l = 1;
        int r = nums.length-2;

        while (l <= r) {
            int mid = l + (r-l)/2;

            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;

            //means we are on an increasing curve,
            //so there must be a peek on the right side.
            if (nums[mid] > nums[mid-1]) {
                l = mid + 1;
            } else if (nums[mid] > nums[mid+1]) {
                //means we are on a decreasing curve,
                //so there must be a peak on the left side.
                r = mid-1;
            } else {
                //otherwise, just got on any side.
                //l = mid + 1 and r = mid-1 both should work here.
                // l = mid + 1;
                r = mid - 1;
            }
        }

        return -1;
    }

    //My soln: O(n)
    private int revise(int[] nums) {
        if (nums.length == 1) return 0;

        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                if (nums[0] > nums[1]) return 0;
            } else if (i==nums.length-1) {
                if (nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
            } else if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }

        return -1;
    }
}
