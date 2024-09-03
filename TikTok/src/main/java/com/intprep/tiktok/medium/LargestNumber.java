package com.intprep.tiktok.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//@link - https://leetcode.com/problems/largest-number/description/
public class LargestNumber {
    public String largestNumber(int[] nums) {
        return largest(nums);
    }

    private String largest(int[] nums) {
        List<Integer> nl = new ArrayList<>();
        boolean allZeros = true;
        for (int num: nums) {
            if (num != 0) allZeros = false;
            nl.add(num);
        }

        if (allZeros) return "0";

        Comparator<Integer> cmp = (i1, i2) -> {
            String n1 = String.valueOf(i1);
            String n2 = String.valueOf(i2);
            String n3 = n1 + n2;
            String n4 = n2 + n1;

            return cmp(n3, n4);
        };

        Collections.sort(nl, cmp);
        StringBuffer sb = new StringBuffer();
        for (int num: nl) sb.append(num);

        return sb.toString();
    }

    private int cmp(String n3, String n4) {
        for (int i=0; i<n3.length(); i++) {
            int dig1 = Character.getNumericValue(n3.charAt(i));
            int dig2 = Character.getNumericValue(n4.charAt(i));
            if (dig1 > dig2) {
                return -1;
            } else if (dig2 > dig1) return 1;
        }

        return 0;
    }
}
