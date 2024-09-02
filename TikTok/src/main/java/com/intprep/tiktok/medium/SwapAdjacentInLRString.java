package com.intprep.tiktok.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//@link - https://leetcode.com/problems/swap-adjacent-in-lr-string/
//@check - https://www.youtube.com/watch?v=3_7tsztReyE
public class SwapAdjacentInLRString {

    /**
     * Approach borrowed from @check.
     * Code written by me.
     */
    public boolean canTransform(String start, String end) {
        return transform(start, end);
    }
    private boolean transform(String start, String end) {
        Deque<Pair2> sl = new ArrayDeque<>();
        Deque<Pair2> se = new ArrayDeque<>();

        //add all L's and R's in start to a stack with their indexes.
        for (int i=0; i<start.length(); i++) {
            char ch = start.charAt(i);
            if (ch == 'L') sl.addFirst(new Pair2('L', i));
            else if (ch == 'R') sl.addFirst(new Pair2('R', i));
        }

        //add all L's and R's in start to another stack with their indexes.
        for (int i=0; i<end.length(); i++) {
            char ch = end.charAt(i);
            if (ch == 'L') se.addFirst(new Pair2('L', i));
            else if (ch == 'R') se.addFirst(new Pair2('R', i));
        }

        //if L's and R's in both strings are diff, then they can never convert to each other.
        if (se.size() != sl.size()) return false;

        while (!sl.isEmpty()) {
            Pair2 s = sl.removeFirst();
            Pair2 e = se.removeFirst();

            //Relative ordering or L and R in both strings
            //should be same. Coz L and R can't be swapped with each other in the start string.
            if (s.ch != e.ch) return false;

            //Since XL converts to LX, end string's corresponding L
            //must be at index less or equal to that of start string.
            if (s.ch == 'L') {
                if (e.idx > s.idx) return false;
            } else {

                //Since RX converts to XR, end string's corresponding R
                //must be at index higher or equal to that of start string.
                if (e.idx < s.idx) return false;
            }
        }

        return true;

    }
}


class Pair2 {
    char ch;
    int idx;

    public Pair2(char ch, int idx) {
        this.ch = ch;
        this.idx = idx;
    }
}