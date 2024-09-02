package com.intprep.tiktok.medium;

import java.util.HashMap;
import java.util.Map;

//@link - https://leetcode.com/problems/coin-change/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // long ans = coinchange(coins, amount, 0, new HashMap<>());
        // return ans == Integer.MAX_VALUE ? -1: (int)ans;

        Map<String, Long> dp = new HashMap<>();
        long ans = revise(coins, 0, amount, dp);
        return ans == Integer.MAX_VALUE ? -1: (int) ans;
    }

    private long revise(int[] coins, int curr, long amount, Map<String, Long> dp) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (curr >= coins.length) return Integer.MAX_VALUE;

        String key = curr + "_" + amount;
        if (dp.containsKey(key)) return dp.get(key);
        long chooseCurr = 1 + revise(coins, curr, amount-coins[curr], dp);
        long skipCurr = revise(coins, curr+1, amount, dp);

        dp.put(key, Math.min(chooseCurr, skipCurr));
        return dp.get(key);
    }

    private long coinchange(int[] coins, int amount, int curr, Map<String, Long> cache) {
        if (amount == 0) {
            return 0;
        }
        if (curr >= coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }

        String key = amount + "-" + curr;
        if (cache.containsKey(key)) return cache.get(key);

        long pick = 1 + coinchange(coins, amount-coins[curr], curr, cache);

        long notPick = coinchange(coins, amount, curr+1, cache);

        cache.put(key, Math.min(pick, notPick));
        return cache.get(key);
    }
}
