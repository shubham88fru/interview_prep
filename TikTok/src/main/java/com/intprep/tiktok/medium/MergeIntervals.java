package com.intprep.tiktok.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//@link - https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        return mint(intervals);
    }

    private int[][] mint(int[][] intervals) {
        Comparator<int[]> cmp1 = (a1, a2) -> a1[0] - a2[0];
        Comparator<int[]> cmp2 = (a1, a2) -> a1[1] - a2[1];

        Arrays.sort(intervals, cmp1.thenComparing(cmp2));

        List<int[]> merged = new ArrayList<>();
        for (int i=0; i<intervals.length; i++) {
            if (merged.size() > 0 && intervals[i][0] <= merged.get(merged.size()-1)[1]) {
                merged.get(merged.size()-1)[1] = Math.max(intervals[i][1], merged.get(merged.size()-1)[1]);
            } else {
                merged.add(intervals[i]);
            }
        }

        int[][] ans = new int[merged.size()][2];
        for (int i=0; i<merged.size(); i++) {
            ans[i] = merged.get(i);
        }

        return ans;
    }
}
