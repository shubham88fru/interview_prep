package com.intprep.tiktok.easy;

import java.util.ArrayDeque;
import java.util.Deque;

//@link - https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        return usingStack(head);
        // return withoutStack(head);
    }

    private ListNode withoutStack(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = curr.next;

        while (next != null) {
            //If curr and next value same..
            if (curr.val == next.val) {
                //We move our prev to curr
                //so that we keep one copy of the duplicate
                //value when we repoint prev's next to the first
                //different value.
                prev = curr;
                //..keep moving next as long as encountering duplicate values.
                while (next != null && curr.val == next.val) {
                    next = next.next;
                }

                //If last node is also a duplicate,
                //prev will become the last node and we're done
                if (next == null) {
                    prev.next = next;
                    return dummy.next;
                }

                //otherwise, point prev's next to the curr's next
                //because it is the first node with value diff than curr.
                //effectively deleting all the nodes after prev till curr.
                //then move curr to next. Next pointer is moved at the bottom
                //NOTE: In this case, prev is not moved. It still points wherever
                //it was because we have deleted the nodes.
                prev.next = next;
                curr = next;
            } else {//..if curr and next not same then,
                prev = curr; //move prev to curr,
                curr = curr.next; //and curr to next.
            }

            //and next to next.
            next = next.next;
        }

        //dummy's next always points to head so return the head.
        return dummy.next;
    }

    private ListNode usingStack(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;
        while (curr != null) {
            if (!stack.isEmpty()) {
                if (stack.peekFirst().val == curr.val) {
                    stack.peekFirst().next = null;
                } else {
                    stack.peekFirst().next = curr;
                    stack.addFirst(curr);
                }
            } else stack.addFirst(curr);
            curr = curr.next;
        }

        return head;
    }
}
