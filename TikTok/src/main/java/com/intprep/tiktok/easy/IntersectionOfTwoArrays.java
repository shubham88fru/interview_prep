package com.intprep.tiktok.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@link - https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int num: nums1) st.add(num);
        for (int num: nums2) {
            if (st.contains(num)) {
                ans.add(num);
                st.remove(num);
            }
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}
