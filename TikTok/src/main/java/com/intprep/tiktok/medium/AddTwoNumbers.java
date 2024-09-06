package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return revise(l1, l2);
    }

    private ListNode revise(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            curr.next = new ListNode(sum);
            curr = curr.next;
            l2 = l2.next;
        }

        if (carry != 0) curr.next = new ListNode(1);

        return dummy.next;
    }
}
