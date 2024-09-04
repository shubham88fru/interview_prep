package com.intprep.tiktok.medium;

import java.util.*;

//@link - https://leetcode.com/problems/word-break/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return revise(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private boolean revise(String s, Set<String> wordDict, Map<String, Boolean> memo) {
        if (wordDict.contains(s)) return true;

        if (memo.containsKey(s)) return memo.get(s);

        for (int i=0; i<s.length(); i++) {
            String sub = s.substring(0, i+1);
            if (wordDict.contains(sub)) {
                if (revise(s.substring(i+1), wordDict, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }

        memo.put(s, false);
        return false;
    }


    private boolean wb(String s, Set<String> dict, Map<Integer, Boolean> cache, int curr) {
        if ("".equals(s)) return true;

        if (cache.containsKey(curr)) return cache.get(curr);
        for (int i=0; i<s.length(); i++) {
            if (dict.contains(s.substring(0, i+1))) {
                String rest = s.substring(i+1);
                if (dict.contains(rest) || wb(rest, dict, cache, i+1)) {
                    cache.put(curr, true);
                    return true;
                }
                //WORKS_HERE
                else cache.put(curr, false);
            }
        }

        /**
         Note putting false in cache here,
         fails some test cases. And if I move it
         to the else case above (marked `WORKS_HERE`),
         the solution works for all cases. Ponder why.
         */
        //cache.put(curr, false);
        return false;
    }
}
