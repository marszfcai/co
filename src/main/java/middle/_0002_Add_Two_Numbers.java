package middle;

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class _0002_Add_Two_Numbers {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(5);
        ListNode resNode = solution.addTwoNumbers(l1, l2);
        System.out.println();
    }

    /**
     * 递归式 可能爆栈
     * 注意指针传递
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode startNode = new ListNode(0);
            addNext(l1, l2, startNode, 0);
            return startNode.next;
        }

        private void addNext(ListNode l1, ListNode l2, ListNode parentNode, int upF) {
            if (l1 == null && l2 == null) {
                if (upF > 0) {
                    parentNode.next = new ListNode(upF);
                }
                return;
            }
            int var1 = l1 != null ? l1.val : 0;
            int var2 = l2 != null ? l2.val : 0;
            int resVal = var1 + var2 + upF;
            int nodeVal = resVal % 10;
            upF = resVal / 10;
            parentNode.next = new ListNode(nodeVal);
            addNext(l1 == null ? null : l1.next, l2 == null ? null : l2.next, parentNode.next, upF);
        }
    }

    static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode e = new ListNode(0);
            ListNode curr = e;
            int upF = 0;
            while (l1 != null || l2 != null) {
                int var1 = l1 != null ? l1.val : 0;
                int var2 = l2 != null ? l2.val : 0;
                int resVal = var1 + var2 + upF;
                int nodeVal = resVal % 10;
                upF = resVal / 10;
                curr.next = new ListNode(nodeVal);
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
                curr = curr.next;
            }
            if (upF > 0) {
                curr.next = new ListNode(upF);
            }
            return e.next;
        }
    }
}
