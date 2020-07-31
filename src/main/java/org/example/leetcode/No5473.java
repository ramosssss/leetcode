package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-27 09:55
 */
public class No5473 {
}

class Solution5473 {
    public int minFlips(String target) {
        String small = compress(target);
        if (small == null || small.length() == 0) {
            return 0;
        }

        return small.indexOf('1') != -1 ? small.length() - small.indexOf('1') : 0;
    }

    private String compress(String target) {
        if (target == null || target.length() == 0) {
            return target;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < target.length()) {
            char c = target.charAt(i);
            while (i < target.length() && target.charAt(i) == c) {
                i++;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}