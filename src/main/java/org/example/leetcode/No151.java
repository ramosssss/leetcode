package org.example.leetcode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-23 15:09
 */
public class No151 {
    class Solution {
        Stack<String> stack = new Stack<>();

        public String reverseWords(String s) {
            if (s == null) {
                throw new NullPointerException("输入参数为空");
            }
            s = s.trim();
            if (s.length() == 0) {
                return s;
            }

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                int j = i;
                StringBuilder sb = new StringBuilder();
                while (j < chars.length && chars[j] != ' ') {
                    sb.append(chars[j++]);
                }
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                }
                i = j;
            }
            return toString();
        }

        @Override
        public String toString() {
            String res = "";
            while (!stack.isEmpty()) {
                res = res + stack.pop() + " ";
            }
            return res.length() == 0 ? res : res.substring(0, res.length() - 1);
        }
    }
}