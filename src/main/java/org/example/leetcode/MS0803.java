package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-31 08:53
 */
public class MS0803 {
}

class SolutionMS0803 {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}