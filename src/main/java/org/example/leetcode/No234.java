package org.example.leetcode;

import org.example.leetcode.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-07 15:11
 */
public class No234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            ListNode mid = getMid(slow, fast);
            ListNode reverseHead = reverse(mid);
            while (reverseHead != null) {
                if (reverseHead.val != head.val) {
                    return false;
                }
                head = head.next;
                reverseHead = reverseHead.next;
            }
            return true;
        }

        private ListNode getMid(ListNode slow, ListNode fast) {
            while (fast != null) {
                slow = slow.next;
                fast = fast.next == null ? null : fast.next.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            ListNode newHead = reverse(head.next);
            next.next = head;
            head.next = null;
            return newHead;
        }
    }
}