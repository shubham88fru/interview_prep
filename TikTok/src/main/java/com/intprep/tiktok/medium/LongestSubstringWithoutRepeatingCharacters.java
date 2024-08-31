package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;

//@link - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        return optimal(s);
    }

    private int optimal(String s) {
        int l = 0;
        int r = 0;
        int max = 0;

        //char v/s index.
        Map<Character, Integer> window = new HashMap<>();
        while (r < s.length()) {
            //if present in the window in valid range.
            if (!window.containsKey(s.charAt(r)) || window.get(s.charAt(r)) < l) {
                window.put(s.charAt(r), r);
                r += 1;
                max = Math.max(r-l, max);
            } else {
                //move l direct to a pos beyond last recorded s.charAt(r)
                l = window.get(s.charAt(r)) + 1;

            }
        }

        return max;
    }

    private int better(String s) {
        int l = 0;
        int r = 0;
        int max = 0;

        //char v/s frequency.
        Map<Character, Integer> window = new HashMap<>();
        while (r < s.length()) {
            if (!window.containsKey(s.charAt(r))) {
                window.put(s.charAt(r), r);
                r += 1;
                max = Math.max(r-l, max);
            } else {
                //delete all till s.charAt(r) disappears.
                while (l < r && window.containsKey(s.charAt(r))) {
                    window.put(s.charAt(l), window.get(s.charAt(l))-1 );
                    if (window.get(s.charAt(l)) == 0) window.remove(s.charAt(l));
                    l += 1;
                }
            }
        }

        return max;
    }
}
