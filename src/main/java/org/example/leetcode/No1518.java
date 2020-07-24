package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-23 10:10
 */
public class No1518 {

    public static void main(String[] args) {
        System.out.println(new Solution().numWaterBottles(15, 4));
    }

}

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        int remain = 0;
        while (numBottles != 0) {
            res += numBottles;
            int total = numBottles + remain;
            numBottles = total / numExchange;
            remain = total - numBottles * numExchange;
        }
        return res;
    }
}