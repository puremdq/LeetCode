package util;

import com.aojiaoo.common.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode gen(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode listNode = new ListNode();
        ListNode head = listNode;

        for (int i = 0; i < arr.length; i++) {
            listNode.val = arr[i];
            if (i != arr.length - 1) {
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }

        return head;
    }

    public static ListNode gen(int t) {
        ListNode head = new ListNode();
        head.val = t;

        return head;
    }

    public static ListNode gen(String s) {
        return gen(JsonUtil.parse(s, int[].class));
    }

    public static void print(ListNode listNode) {

        List<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(res);
    }
}
