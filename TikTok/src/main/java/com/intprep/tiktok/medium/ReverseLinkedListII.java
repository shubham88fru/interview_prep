package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/reverse-linked-list-ii/description/
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return revise(head, left, right);
    }

    private ListNode revise(ListNode head, int left, int right) {
        if (head == null) return null;

        int i = 1;

        ListNode leftN = null;
        ListNode rightN = null;
        ListNode firstN = null;
        ListNode lastN = null;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            if (i < left) {
                leftN = curr;
                prev = curr;
                curr = curr.next;
            } else if (i >= left && i <= right) {
                if (firstN == null) firstN = curr;
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            } else {
                lastN = prev;
                rightN = curr;
                break;
            }
            i += 1;
        }

        firstN.next = rightN;
        if (leftN != null) leftN.next = prev;

        if (leftN != null) return head;
        return prev;
    }
}
