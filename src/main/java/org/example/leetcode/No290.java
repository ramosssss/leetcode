package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-24 11:29
 */
public class No290 {
}

class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        char[] cs = pattern.toCharArray();
        String[] ss = str.split(" ");
        if (cs.length != ss.length) {
            return false;
        }

        for (int i = 0; i < cs.length; ++i) {
            char c = cs[i];
            String s = ss[i];
            if (!map1.containsKey(c)) {
                if (map2.containsKey(s)) {
                    return false;
                }
                map1.put(c, s);
                map2.put(s, c);
            } else {
                if (!map1.get(c).equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}