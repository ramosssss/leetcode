package org.example;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-23 09:48
 */
public class No1502 {
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            if (arr == null) {
                throw new NullPointerException("传入参数为空");
            }
            if (arr.length == 0) {
                return false;
            }
            Arrays.sort(arr);
            for (int i = 1; i < arr.length - 1; ++i) {
                if (arr[i - 1] - arr[i] != arr[i] - arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}