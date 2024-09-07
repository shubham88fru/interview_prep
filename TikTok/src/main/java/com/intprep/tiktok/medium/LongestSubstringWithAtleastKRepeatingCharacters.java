package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//@link - https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtleastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return longest(s, k);
    }

    /**
     Good thing to learn from this problem is the use
     of recursion with sliding window. Below is my
     solution, but not very happy with the solution.
     On next encouter, try to see if you can optimize
     it further.
     */
    private int longest(String s, int k) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch: s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }

        int l = 0;
        int r = 0;
        int maxLen = 0;

        Map<Character, Integer> window = new HashMap<>();
        Set<Character> lessThanK = new HashSet<>();
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (freq.get(ch) >= k) {
                r += 1;
                window.put(ch, window.getOrDefault(ch, 0)+1);
                if (window.get(ch) < k) lessThanK.add(ch);
                else lessThanK.remove(ch);

                if (lessThanK.size() == 0) maxLen = Math.max(maxLen, r-l);
                else maxLen = Math.max(maxLen, longest(s.substring(l, r), k));
            } else {
                r += 1;
                l = r;
                window.clear();
                lessThanK.clear();
            }
        }

        return maxLen;
    }
}
