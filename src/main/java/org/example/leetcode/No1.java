package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-30 17:25
 */
public class No1 {
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i)
        {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }

        return new int[]{-1, -1};
    }
}