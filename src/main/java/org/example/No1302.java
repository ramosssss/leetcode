package org.example;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-01 13:08
 */
public class No1302 {

    public static void main(String[] args) {

    }

    /**
     * 维护两个数字，当前最深层数以及和。
     * 若当前层数比最深层数小，略过；
     * 若当前层数和最深层数相同，和加上当前节点的数；
     * 若当前层数比最深层数大，和变为当前节点的数。
     */
    class Solution {
        int maxLevel = -1;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            helper(root, 0);
            return sum;
        }

        private void helper(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (level > maxLevel) {
                maxLevel = level;
                sum = root.val;
            } else if (level == maxLevel) {
                sum += root.val;
            }

            helper(root.left, level + 1);
            helper(root.right, level + 1);
        }
    }
}
