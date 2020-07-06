package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-03 15:24
 */
public class No114 {
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            List<TreeNode> list = new ArrayList<>();
            helper(list, root);
            TreeNode newRoot = new TreeNode(0);
            for (TreeNode node : list) {
                node.left = null;
                node.right = null;
                newRoot.right = node;
                newRoot = node;
            }
            newRoot.right = null;
        }

        private void helper(List<TreeNode> treeNodeList, TreeNode root) {
            if (root == null) {
                return;
            }
            treeNodeList.add(root);
            helper(treeNodeList, root.left);
            helper(treeNodeList, root.right);
        }
    }


}