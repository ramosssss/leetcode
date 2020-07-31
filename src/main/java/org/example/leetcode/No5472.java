package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-27 09:25
 */
public class No5472 {
}

class Solution5472 {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[indices.length];

        for (int i = 0; i < indices.length; ++i) {
            res[indices[i]] = s.charAt(i);
        }
        return new String(res);
    }
}