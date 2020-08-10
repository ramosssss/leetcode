package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-08-08 13:36
 */

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No77 {
    public static void main(String[] args) {
        List<List<Integer>> res = new Solution77().combine(4, 2);
        System.out.println("");
    }

}

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> temp, int level, int n, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = level; i <= n; ++i) {
            temp.add(i);
            helper(res, temp, i + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }
}