package com.intprep.tiktok.easy;

//@link - https://leetcode.com/problems/merge-sorted-array/description/
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int l = nums1.length-1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[l] = nums1[i];
                i -= 1;
            } else {
                nums1[l] = nums2[j];
                j -= 1;
            }
            l -= 1;
        }

        while (i >= 0) {
            nums1[l] = nums1[i];
            i -= 1;
            l -= 1;
        }

        while (j >= 0) {
            nums1[l] = nums2[j];
            j -= 1;
            l -= 1;
        }
    }
}
