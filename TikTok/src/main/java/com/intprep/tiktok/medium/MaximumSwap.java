package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/maximum-swap/
public class MaximumSwap {
    public int maximumSwap(int num) {
        /**
         My soln, but isn't optimal.
         Maybe try to find a optimal soln on next encounter.
         */
        StringBuffer ns = new StringBuffer(String.valueOf(num));
        int max = num;
        for (int i=0; i<ns.length(); i++) {
            for (int j=i+1; j<ns.length(); j++) {
                //////optimization
                if (
                        Character.getNumericValue(ns.charAt(j)) < Character.getNumericValue(ns.charAt(i))

                ) continue;
                ////////
                char temp = ns.charAt(i);
                ns.setCharAt(i, ns.charAt(j));
                ns.setCharAt(j, temp);

                if (Integer.parseInt(ns.toString()) > max) {
                    max = Integer.parseInt(ns.toString());
                }

                ns.setCharAt(j, ns.charAt(i));
                ns.setCharAt(i, temp);
            }
        }
        return max;
    }
}
