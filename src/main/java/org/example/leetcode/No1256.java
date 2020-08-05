package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-08-03 10:55
 */
public class No1256 {
    public static void main(String[] args) {
        for (int i = 0; i < 23; i++) {
            System.out.println(new Solution1256().encode(i));
        }
    }
}

class Solution1256 {
    public String encode(int num) {
        if (num == 0) {
            return "";
        }

        String bin = Integer.toBinaryString(num);
        if ((num & (num + 1)) == 0) {
            return buildZero(bin.length());
        } else {
            String temp = Integer.toBinaryString(num - (int) Math.pow(2, bin.length() - 1) + 1);
            if (temp.length() == bin.length() - 1) {
                return temp;
            } else {
                return buildZero(bin.length() - 1 - temp.length()) + temp;
            }
        }
    }

    private String buildZero(int length) {
        StringBuilder sb = new StringBuilder();
        while (length-- > 0) {
            sb.append('0');
        }
        return sb.toString();
    }
}