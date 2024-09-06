package com.intprep.tiktok.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//@link - https://leetcode.com/problems/add-two-numbers-ii/
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // return revise(l1, l2);
        return reviseStack(l1, l2);
    }
    //1) Without reversing the list - using stack.
    private ListNode reviseStack(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();

        ListNode curr1 = l1;
        while (curr1 != null) {
            stack1.addFirst(curr1);
            curr1 = curr1.next;
        }

        ListNode curr2 = l2;
        while (curr2 != null) {
            stack2.addFirst(curr2);
            curr2 = curr2.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        Deque<ListNode> stack3 = new ArrayDeque<>();

        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.removeFirst().val + stack2.removeFirst().val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            // curr.next = new ListNode(sum);
            stack3.addFirst(new ListNode(sum));
        }

        while (!stack1.isEmpty()) {
            int sum = stack1.removeFirst().val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;
            stack3.addFirst(new ListNode(sum));
        }

        while (!stack2.isEmpty()) {
            int sum = stack2.removeFirst().val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;
            stack3.addFirst(new ListNode(sum));
        }

        if (carry == 1) stack3.addFirst(new ListNode(1));

        while (!stack3.isEmpty()) {
            curr.next = stack3.removeFirst();
            curr = curr.next;
        }

        return dummy.next;
    }

    //2) by reversing the list
    private ListNode revise(ListNode l1, ListNode l2) {
        ListNode l1rev = reverse(l1);
        ListNode l2rev = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;
        while (l1rev != null && l2rev != null) {
            int sum = l1rev.val + l2rev.val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            curr.next = new ListNode(sum);
            curr = curr.next;
            l1rev = l1rev.next;
            l2rev = l2rev.next;
        }

        while (l1rev != null) {
            int sum = l1rev.val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            curr.next = new ListNode(sum);
            curr = curr.next;
            l1rev = l1rev.next;
        }

        while (l2rev != null) {
            int sum = l2rev.val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            curr.next = new ListNode(sum);
            curr = curr.next;
            l2rev = l2rev.next;
        }

        if (carry != 0) curr.next = new ListNode(1);
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next =  prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
