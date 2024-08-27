package com.intprep.tiktok.easy;

//@link - https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        //Make list1 as the base.
        if (list2.val < list1.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode prev = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;

        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                prev = curr1;
                curr1 = curr1.next;
            } else {
                prev.next = curr2;
                prev = curr2;
                curr2 = curr2.next;
                prev.next = curr1;
            }
        }

        if (curr1 != null) prev.next = curr1;
        else if (curr2 != null) prev.next = curr2;

        return dummy.next;
    }
}
