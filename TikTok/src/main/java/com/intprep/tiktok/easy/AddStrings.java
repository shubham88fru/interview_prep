package com.intprep.tiktok.easy;

//@link - https://leetcode.com/problems/add-strings/
public class AddStrings {
    public String addStrings(String num1, String num2) {
        String larger = num1;
        String smaller = num2;
        if (num1.length() < num2.length()) {
            larger = num2;
            smaller = num1;
        }

        int carry = 0;
        int p1 = larger.length()-1;
        int p2 = smaller.length()-1;
        StringBuffer sb = new StringBuffer();
        while (p2 >= 0) {
            int sum = Character.getNumericValue(larger.charAt(p1))
                    + Character.getNumericValue(smaller.charAt(p2)) + carry;

            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else carry = 0;
            sb.append(String.valueOf(sum));

            p2 -= 1;
            p1 -= 1;
        }

        while (p1 >=0) {
            int sum = Character.getNumericValue(larger.charAt(p1)) + carry;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else carry = 0;
            sb.append(String.valueOf(sum));

            p1 -= 1;
        }

        if (carry == 1) sb.append("1");

        return sb.reverse().toString();
    }
}
