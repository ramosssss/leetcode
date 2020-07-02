package org.example;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-02 16:51
 */
public class No938 {
    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            if (root.val < L) {
                res += rangeSumBST(root.right, L, R);
            } else if (root.val > R) {
                res += rangeSumBST(root.left, L, R);
            } else {
                res += root.val + rangeSumBST(root.right, L, R) +  rangeSumBST(root.left, L, R);
            }
            return res;
        }
    }
}