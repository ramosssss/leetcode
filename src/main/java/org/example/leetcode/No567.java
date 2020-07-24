package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-24 09:38
 */
public class No567 {
    public static void main(String[] args) {
        System.out.println(new Solution567().checkInclusion("ab", "eidbcaooo"));
    }
}

class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        String temp = s1;
        s1 = s2;
        s2 = temp;
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 < len2) {
            return false;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : cs2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < len2; ++i) {
            char c = cs1[i];
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = len2;
        while (end <= len1) {
            if (compare(map1, map2)) {
                return true;
            }
            map1.put(cs1[start], map1.get(cs1[start]) - 1);
            if (end < len1) {
                map1.put(cs1[end], map1.getOrDefault(cs1[end], 0) + 1);
            }
            end++;
            start++;
        }
        return false;
    }

    private boolean compare(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character c : map2.keySet()) {
            if (!map1.containsKey(c) || !map1.get(c).equals(map2.get(c))) {
                return false;
            }
        }
        return true;
    }
}