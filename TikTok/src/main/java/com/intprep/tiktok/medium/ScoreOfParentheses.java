package com.intprep.tiktok.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//@link - https://leetcode.com/problems/score-of-parentheses/
public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Deque<StackPair> stack = new ArrayDeque<>();
        int totalSum = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.addFirst(new StackPair(ch, 1, 0, totalSum));
            } else {
                if (ch == ')') {
                    StackPair opening = stack.removeFirst();
                    if (!stack.isEmpty()) {
                        if (opening.currSum == 0) stack.peekFirst().currSum += 1;
                        else stack.peekFirst().currSum += opening.mult*opening.currSum;
                    } else {
                        if (opening.currSum == 0) totalSum += 1;
                        else totalSum = totalSum + (opening.mult*opening.currSum);
                    }
                } else {
                    stack.peekFirst().mult = 2;
                    stack.addFirst(new StackPair(ch, 1, 0, totalSum));
                }
            }
        }

        return totalSum;
    }
}

class StackPair {
    char ch;
    int mult;
    int currSum;
    int totalSum;

    public StackPair(char ch, int mult, int currSum, int totalSum) {
        this.ch = ch;
        this.mult = mult;
        this.currSum = currSum;
        this.totalSum = totalSum;
    }
}