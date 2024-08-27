package com.intprep.tiktok.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@link - https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        // return sol1(nums1, nums2);
        return sol3(nums1, nums2);
    }

    private int[] sol3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp1 = new HashMap<>();
        for (int num: nums1) {
            mp1.put(num, mp1.getOrDefault(num, 0)+1);
        }

        Map<Integer, Integer> mp2 = new HashMap<>();
        for (int num: nums2) {
            mp2.put(num, mp2.getOrDefault(num, 0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: mp1.entrySet()) {
            if (mp2.containsKey(entry.getKey())) {
                int times = Math.min(entry.getValue(), mp2.get(entry.getKey()));
                for (int i=0; i<times; i++) ans.add(entry.getKey());
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();

    }

    private int[] sol1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num: nums1) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int num: nums2) {
            if (mp.containsKey(num) && mp.get(num) > 0) {
                ans.add(num);
                mp.put(num, mp.get(num)-1);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    //My soln - unneccesarily complicated.
    private int[] sol2(int[] nums1, int[] nums2) {
        //nums1 element frequencies.
        Map<Integer, Integer> mp1 = new HashMap<>();

        //nums2 element frequences.
        Map<Integer, Integer> mp2 = new HashMap<>();

        List<Integer> ans = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        for (int num: nums1) {
            mp1.put(num, mp1.getOrDefault(num, 0)+1);
        }

        for (int num: nums2) {
            mp2.put(num, mp2.getOrDefault(num, 0)+1);
        }

        Map<Integer, Integer> smaller
                = mp1.size() >= mp2.size() ? mp2 : mp1;
        Map<Integer, Integer> bigger
                = mp2.size() > mp1.size() ? mp2 : mp1;

        //iterate over smaller map, and find the same key in other map
        //if it exists, means that element is common in both the arrays.
        //We then just need to copy that element num of times equal to
        //the smaller of two frequencies (since we're finding intersection)
        for (Map.Entry<Integer, Integer> entry: smaller.entrySet()) {
            if (bigger.containsKey(entry.getKey())) {
                int min = Math.min(entry.getValue(), bigger.get(entry.getKey()));
                while (min > 0) {
                    ans.add(entry.getKey());
                    min -= 1;
                }
            }
        }


        return ans.stream().mapToInt(i -> i).toArray();
    }
}
