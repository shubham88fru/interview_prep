package com.intprep.tiktok.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//@link - https://leetcode.com/problems/decode-string/
public class DecodeString {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) stack.addFirst(ch);
            else if (ch != ']') stack.addFirst(ch);
            else {
                StringBuffer sb = new StringBuffer();
                while (!stack.isEmpty() && (stack.peekFirst() != '[')) {
                    sb.append(stack.removeFirst());
                }
                sb.reverse();
                stack.removeFirst();

                int dig = 0;
                int pow = 0;
                while (!stack.isEmpty() && (Character.isDigit(stack.peekFirst()))) {
                    int num = Character.getNumericValue(stack.removeFirst());
                    dig += (Math.pow(10, pow)*num);
                    pow += 1;

                }
                StringBuffer repeated = new StringBuffer();
                while (dig > 0) {
                    repeated.append(sb.toString());
                    dig -= 1;
                }
                for (int j=0; j<repeated.length(); j++) {
                    stack.addFirst(repeated.charAt(j));
                }
            }
        }

        StringBuffer ans = new StringBuffer();
        while (!stack.isEmpty()) {
            ans.append(stack.removeFirst());
        }

        return ans.reverse().toString();
    }
}
