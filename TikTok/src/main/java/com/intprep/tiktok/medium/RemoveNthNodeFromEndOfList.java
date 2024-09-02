package com.intprep.tiktok.medium;

//@link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prev = new ListNode(-1);

        ListNode slow = head;
        prev.next = slow;
        ListNode fast = head;

        int i = 0;
        while (i < n) {
            fast = fast.next;
            i += 1;
        }

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        //If slow is still pointing to head
        //means head is to be removed.
        if (slow == head) return slow.next;

        //else, some later element of the list is
        //to be removed.
        prev.next = slow.next;
        slow.next = null;

        return head;
    }
}
