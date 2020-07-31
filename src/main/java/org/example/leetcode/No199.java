package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-31 13:22
 */
public class No199 {

}

/**
 * 首先咱们想到的一定是层序遍历，这是最常规的解法
 * 进阶的话，用递归，创建一个map，先序，并先右边子树
 */
class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        helper(root, map, 0);
        for (int i = 0; i < map.size(); ++i) {
            res.add(map.get(i).val);
        }
        return res;
    }

    private void helper(TreeNode root, Map<Integer, TreeNode> map, int level) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, root);
        }
        helper(root.right, map, level + 1);
        helper(root.left, map, level + 1);
    }
}