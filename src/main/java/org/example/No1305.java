package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-06 18:59
 */
public class No1305 {
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            travel(root1, list1);
            travel(root2, list2);
            return merge(list1, list2);
        }

        private void travel(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            travel(root.left, list);
            list.add(root.val);
            travel(root.right, list);
        }

        private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
            List<Integer> res = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (i < list1.size() && j < list2.size()) {
                if (list1.get(i) <= list2.get(j)) {
                    res.add(list1.get(i++));
                } else {
                    res.add(list2.get(j++));
                }
            }
            while (i < list1.size()) {
                res.add(list1.get(i++));
            }
            while (j < list2.size()) {
                res.add(list2.get(j++));
            }
            return res;
        }
    }
}