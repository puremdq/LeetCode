package com.aojiaoo.leetcode;


/**
 * @author moudengquan
 * @link {https://leetcode-cn.com/problems/add-two-numbers/}
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = l1;

        if (l1 == null && l2 == null) {
            return null;
        }

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                l1 = l2;
                l2 = null;
            }
            int temp = addCurrent(l1, l2);
            if (temp >= 10) {
                if (l1.next == null) {
                    l1.next = new ListNode(0);
                }
                l1.next.val = l1.next.val + 1;
                temp = temp - 10;
            }
            l1.val = temp;
            if (l1.next == null && l2 != null && l2.next != null) {
                l1.next = l2.next;
                l2.next = null;
            }
            l1 = l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return res;
    }


    int addCurrent(ListNode l1, ListNode l2) {
        int i1 = l1 == null ? 0 : l1.val;
        int i2 = l2 == null ? 0 : l2.val;
        return i1 + i2;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
