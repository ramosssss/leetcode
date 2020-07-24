package org.example.leetcode;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-23 15:49
 */
public class No43 {
    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("9", "9"));
    }


}

class Solution43 {

    int[] data1;
    int[] data2;
    int[] dataSum;

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new NullPointerException("传入参数为空");
        }
        if (num1.length() == 0 || num2.length() == 0) {
            throw new InvalidParameterException("传入参数不正确");
        }

        int len1 = num1.length();
        int len2 = num2.length();

        data1 = new int[len1];
        data2 = new int[len2];
        dataSum = new int[len1 * len2 + 1];

        for (int i = 0; i < num1.length(); ++i) {
            data1[num1.length() - 1 - i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < num2.length(); ++i) {
            data2[num2.length() - 1 - i] = num2.charAt(i) - '0';
        }

        for (int i = 0; i < data2.length; ++i) {

            for (int j = 0; j < data1.length; ++j) {
                int pos = i + j;
                dataSum[pos] += data2[i] * data1[j];
            }
        }

        return toString();
    }

    @Override
    public String toString() {
        if (dataSum == null || dataSum.length == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < dataSum.length; ++i) {
            int cur = carry + dataSum[i];
            sb.append(cur % 10);
            carry = cur / 10;
        }
        int start = 0;
        sb = sb.reverse();
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        return start >= sb.length() ? "0" : sb.substring(start);
    }
}