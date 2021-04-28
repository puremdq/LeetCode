package com.aojiaoo.leetcode;//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 1278 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class ListNode {
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

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = findMinNode(lists);
        ListNode copyRes = res;
        if (res == null) {
            return res;
        }
        ListNode minNode = null;
        do {
            minNode = findMinNode(lists);
            if (minNode != null) {
                copyRes.next = minNode;
                copyRes = copyRes.next;
            }
        } while (minNode != null);
        return res;
    }

    public ListNode findMinNode(ListNode[] lists) {
        Integer min = null;
        Integer minIndex = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && (min == null || lists[i].val < min)) {
                min = lists[i].val;
                minIndex = i;
            }
        }
        if (min == null) {
            return null;
        }
        ListNode minNode = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        return minNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
