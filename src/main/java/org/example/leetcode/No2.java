package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-31 11:27
 */
public class No2 {
}
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry /= 10;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return newHead.next;
    }
}