package org.example;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-02 09:45
 */
public class No617 {
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            } else if (t1 == null) {
                return t2;
            } else if (t2 == null) {
                return t1;
            }
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        }
    }
}