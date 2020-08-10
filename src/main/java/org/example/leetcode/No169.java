package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-08-10 11:17
 */
public class No169 {
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int n : nums) {
            if (n == res) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res = n;
                    count = 1;
                }
            }
        }
        return res;
    }
}