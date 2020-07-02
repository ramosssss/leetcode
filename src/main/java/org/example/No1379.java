package org.example;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-01 13:31
 */
public class No1379 {
    public static void main(String[] args) {

    }
    /**
     * 依样画葫芦
     */
    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (original == null) {
                return null;
            }
            if (original == target) {
                return cloned;
            }
            TreeNode res = getTargetCopy(original.left, cloned.left, target);
            return res == null ? getTargetCopy(original.right, cloned.right, target) : res;
        }
    }
}