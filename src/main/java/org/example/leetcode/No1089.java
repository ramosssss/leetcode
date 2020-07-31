package org.example.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-24 13:33
 */
public class No1089 {

    public static void main(String[] args) {
        int[] arr = new int[] {1,0,2,0,3};
        new Solution1089().duplicateZeros(arr);
        System.out.println("");
    }
}

class Solution1089 {

    private static int MIN_LENGTH = 2;
    public void duplicateZeros(int[] arr) {

        if (arr == null || arr.length < MIN_LENGTH) {
            return;
        }
        LinkedList<Integer> bak = new LinkedList<>();

        // 找到第一个 0 所在的位置
        int start = 0;
        while (start < arr.length) {
            if (arr[start] == 0) {
                break;
            }
            start++;
        }
        if (start >= arr.length) {
            return;
        }

        while (start < arr.length) {
            bak.addLast(arr[start]);
            arr[start] = bak.pollFirst();
            if (arr[start] == 0) {
                if (start + 1 < arr.length) {
                    bak.addLast(arr[start + 1]);
                    arr[start + 1] = 0;
                    start += 2;
                } else {
                    start++;
                }

            } else {
                start++;
            }
        }
    }
}