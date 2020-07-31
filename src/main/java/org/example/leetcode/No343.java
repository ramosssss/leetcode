package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-30 17:06
 */
public class No343 {
    public static void main(String[] args) {
        System.out.println(new Solution343().integerBreak(8));
    }
}

class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i / 2; ++j) {
                int temp = Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]);
                max = Math.max(max, temp);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}