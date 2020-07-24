package org.example.leetcode;

import org.example.leetcode.TreeNode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-09 19:13
 */
public class No687 {
    class Solution {
        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int mid = count(root.left, root.val) + count(root.right, root.val);
            int compare = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
            return Math.max(mid, compare);
        }

        private int count(TreeNode root, int val) {
            if (root == null || root.val != val) {
                return 0;
            }
            return 1 + Math.max(count(root.left, val), count(root.right, val));
        }
    }
}