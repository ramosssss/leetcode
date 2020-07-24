package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-01 09:29
 */

import org.example.leetcode.TreeNode;

import java.util.Stack;


public class No654 {

    public static void main(String[] args) {

    }

    /**
     * 用递归解决这个问题
     * 找到数组中的最大值，设置为当前的根节点，左子节点为左边数组返回的结果，右子节点为右边数组返回的结果，并返回根节点。
     * 特别的，当数组的大小为 0 时，返回 null 。
     */
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }
            int maxIndex = findMaxIndex(nums, l, r);
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = helper(nums, l, maxIndex - 1);
            root.right = helper(nums, maxIndex + 1, r);
            return root;
        }

        private int findMaxIndex(int[] nums, int l, int r) {
            int res = l;
            for (int i = l; i <= r; ++i) {
                if (nums[i] > nums[res]) {
                    res = i;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            Stack<TreeNode> stack = new Stack<>();
            for (int n : nums) {
                TreeNode node = new TreeNode(n);
                TreeNode pre = null;
                while (!stack.isEmpty() && stack.peek().val < n) {
                    stack.peek().right = pre;
                    pre = stack.pop();
                }
                node.left = pre;
                stack.push(node);
            }
            TreeNode pre = null;
            while (!stack.isEmpty()) {
                stack.peek().right = pre;
                pre = stack.pop();
            }
            return pre;
        }
    }
}

