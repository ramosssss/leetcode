package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-08-08 13:03
 */
public class No404 {

}

class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);


    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        return helper(root.left, true) + helper(root.right, false);
    }
}