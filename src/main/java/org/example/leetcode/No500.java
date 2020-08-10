package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-08-10 10:54
 */
public class No500 {
}

/**
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 */

class Solution500 {

    private static final String LEVEL_ONE = "qwertyuiop";

    private static final String LEVEL_TWO = "asdfghjkl";

    private static final String LEVEL_THREE = "zxcvbnm";

    private int[] level;

    public Solution500() {
        level = new int[256];
        for (char c : LEVEL_ONE.toCharArray()) {
            level[c] = 1;
            level[Character.toUpperCase(c)] = 1;
        }
        for (char c : LEVEL_TWO.toCharArray()) {
            level[c] = 2;
            level[Character.toUpperCase(c)] = 2;
        }
        for (char c : LEVEL_THREE.toCharArray()) {
            level[c] = 3;
            level[Character.toUpperCase(c)] = 3;
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            boolean flag = true;
            int temp = level[word.charAt(0)];
            for (char c : word.toCharArray()) {
                if (level[c] != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}