package com.intprep.tiktok.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return better(headA, headB);
    }

    //optimal sol. S: O(1), T: O(N+M)
    private ListNode findIntersectionOptimal2(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        //get lengths of each list
        int lenA = 0;
        int lenB = 0;
        while (currA != null) {
            currA = currA.next;
            lenA += 1;
        }
        while (currB != null) {
            currB = currB.next;
            lenB += 1;
        }

        //reset the pointers back to head.
        currA = headA;
        currB = headB;

        //find the diff in length
        int lenDiff = Math.abs(lenA-lenB);

        //if listA is bigger,
        //move its pointer, by difference of
        //the length ahead. Otherwise, if listB is bigger
        //move B's pointer by lenDiff ahead.
        if (lenA > lenB) {
            while (lenDiff != 0) {
                currA = currA.next;
                lenDiff -= 1;
            }
        } else if (lenB > lenA) {
            while (lenDiff != 0) {
                currB = currB.next;
                lenDiff -= 1;
            }
        }

        //once the two pointers are at same level,
        //start moving them together, if there is an
        //intersection, the pointers will point to the same
        //node at some time.
        while (currA != null && currB != null) {
            if (currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }

        //no intersection
        return null;
    }

    //Better sol. S: O(N), T: O(M+N)
    private ListNode better(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (nodes.contains(curr)) return curr;
            curr = curr.next;
        }
        return null;
    }

}
