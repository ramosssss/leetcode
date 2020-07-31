package org.example.leetcode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-31 13:47
 */
public class No20 {
}

/**
 * 这题用栈就好啦
 */
class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(': {
                    stack.push(c);
                    break;
                }
                case '}':
                case ']':
                case ')':
                {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (c == ')' && stack.peek() != '(') {
                        return false;
                    }
                    if (c == ']' && stack.peek() != '[') {
                        return false;
                    }
                    if (c == '}' && stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
                }
                default: {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}