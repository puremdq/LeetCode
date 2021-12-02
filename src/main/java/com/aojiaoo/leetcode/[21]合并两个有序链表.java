package com.aojiaoo.leetcode;

import util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l2 == null) {
            return l1;
        }


        if (l1 == null) {
            return l2;
        }

        ListNode head = l1;

        while (true) {

            if (l2 == null) {
                return head;
            }
            int val1 = l1.val;
            int val2 = l2.val;
            if (val2 < val1) {
                head = l2;
                l2 = l2.next;
                head.next = l1;

                l1 = head;

                continue;
            }

            ListNode l1Next = l1.next;
            if (l1Next == null) {
                l1.next = l2;
                return head;
            }


            if (val2 < l1Next.val) {
                l1.next = l2;
                l2 = l2.next;
                l1.next.next = l1Next;
            } else {
                l1 = l1.next;
            }
        }
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        ListNode.print(solution21.mergeTwoLists(ListNode.gen(5), ListNode.gen("[1,2,4,5]")));
    }


}
