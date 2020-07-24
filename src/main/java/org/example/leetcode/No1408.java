package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-07 14:02
 */
public class No1408 {
    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> res = new ArrayList<>();
            if (words == null || words.length == 0) {
                return res;
            }
            // 根据长度排序
            Arrays.sort(words, (a, b) -> b.length() - a.length());

            for (int i = 0; i < words.length; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (words[j].indexOf(words[i]) != -1) {
                        res.add(words[i]);
                        break;
                    }
                }
            }
            return res;
        }
    }
}