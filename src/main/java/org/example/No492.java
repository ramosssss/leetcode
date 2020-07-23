package org.example;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-10 13:40
 */
public class No492 {
    class Solution {
        public int[] constructRectangle(int area) {
            for (int i = (int) Math.sqrt(area); i <= area; ++i) {
                if (area % i == 0) {
                    if (i < area / i) {
                        continue;
                    }
                    return new int[] {i, area / i};
                }
            }
            return new int[] {area, 1};
        }
    }
}