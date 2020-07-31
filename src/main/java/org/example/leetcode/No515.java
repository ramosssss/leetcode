package org.example.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-31 16:53
 */
public class No515 {
}

class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        helper(root, map, 0);
        for (int i = 0; i < map.size(); ++i) {
            res.add(map.get(i));
        }
        return res;
    }

    private void helper(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root == null) {
            return;
        }
        map.put(level, Math.max(root.val, map.getOrDefault(level, Integer.MIN_VALUE)));
        helper(root.left, map, level + 1);
        helper(root.right, map, level + 1);
    }
}