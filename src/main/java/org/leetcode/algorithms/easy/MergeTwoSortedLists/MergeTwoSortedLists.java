package org.leetcode.algorithms.easy.MergeTwoSortedLists;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode headRes = list1.val >= list2.val ? list2 : list1;

        if (headRes.equals(list1)) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        addNode(list1, list2, headRes);

        return headRes;
    }

    private static void addNode(ListNode list1, ListNode list2, ListNode head) {
        if (list1 == null && list2 == null) {
            return;
        } else if (list1 == null) {
            head.next = list2;
            return;
        } else if (list2 == null) {
            head.next = list1;
            return;
        }

        if (list1.val <= list2.val) {
            head.next = list1;
            list1 = list1.next;
        } else {
            head.next = list2;
            list2 = list2.next;
        }

        addNode(list1, list2, head.next);
    }
}
