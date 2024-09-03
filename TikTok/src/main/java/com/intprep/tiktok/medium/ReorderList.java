package com.intprep.tiktok.medium;

import java.util.ArrayList;
import java.util.List;

//@link - https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public void reorderList(ListNode head) {
        reviseOptimal(head);
    }

    private void reviseOptimal(ListNode head) {
        ListNode firstHalf = head;
        ListNode secondHalf = half(head);


        ListNode secondHalfReversed = reverse(secondHalf);
        merge(firstHalf, secondHalfReversed);
    }

    private ListNode half(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;

        return right;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while (curr1 != null && curr2 != null) {
            ListNode curr1Next = curr1.next;
            ListNode curr2Next = curr2.next;
            curr1.next = curr2;
            curr2.next = curr1Next;
            curr1 = curr1Next;
            curr2 = curr2Next;
        }
    }


    private void revise(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        int sz = nodes.size();
        int i=0;
        int j = nodes.size()-1;
        while (i <= j) {
            nodes.get(i).next = nodes.get(j);
            i += 1;

            if (sz%2 == 0) {
                if (i < nodes.size()/2) nodes.get(j).next = nodes.get(i);
                else nodes.get(j).next = null;
            } else {
                if (i <= nodes.size()/2) nodes.get(j).next = nodes.get(i);
                else nodes.get(j).next = null;
            }

            j -= 1;
        }
    }
}
