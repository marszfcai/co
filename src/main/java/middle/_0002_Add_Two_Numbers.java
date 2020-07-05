package middle;

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
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int resVal = l1.val + l2.val;
            ListNode resNode = new ListNode(0);
            if (resVal >= 10) {
                resVal -= 10;
                resNode.next = new ListNode(1);
            }
            resNode.val += resVal;
            addNext(l1.next, l2.next, resNode);
            return resNode;
        }

        private void addNext(ListNode l1, ListNode l2, ListNode parentNode) {
            if (l1 == null && l2 == null) {
                return;
            }
            int var1 = 0;
            int var2 = 0;
            if (l1 != null) {
                var1 = l1.val;
            }
            if (l2 != null) {
                var2 = l2.val;
            }
            int resVal = var1 + var2;
            if (parentNode.next == null) {
                parentNode.next = new ListNode(0);
            }
            parentNode.next.val += resVal;
            if (parentNode.next.val >= 10) {
                parentNode.next.val -= 10;
                parentNode.next.next = new ListNode(1);
            }
            addNext(l1 == null ? null : l1.next, l2 == null ? null : l2.next, parentNode.next);
        }
    }
}
