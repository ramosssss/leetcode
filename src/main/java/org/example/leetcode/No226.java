package org.example.leetcode;

import org.example.leetcode.TreeNode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-03 09:09
 */
public class No226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode newLeft = invertTree(root.right);
            TreeNode newRight = invertTree(root.left);
            root.left = newLeft;
            root.right = newRight;
            return root;
        }
    }
}