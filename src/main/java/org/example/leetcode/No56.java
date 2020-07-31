package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-31 14:11
 */
public class No56 {
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);
        List<Integer[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            while (i < intervals.length && intervals[i][0] <= r) {
                r = Math.max(r, intervals[i][1]);
                i++;
            }
            list.add(new Integer[] {l, r});
        }
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); ++j) {
            res[j] = new int[] {list.get(j)[0], list.get(j)[1]};
        }
        return res;
    }
}