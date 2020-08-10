package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-08-07 13:23
 */

import java.util.*;

/**
 * 给定一个形如 “HH:MM” 表示的时刻，利用当前出现过的数字构造下一个距离当前时间最近的时刻。每个出现数字都可以被无限次使用。
 * <p>
 * 你可以认为给定的字符串一定是合法的。例如，“01:34” 和 “12:09” 是合法的，“1:34” 和 “12:9” 是不合法的。
 * <p>
 *  
 * <p>
 * 样例 1:
 * <p>
 * 输入: "19:34"
 * 输出: "19:39"
 * 解释: 利用数字 1, 9, 3, 4 构造出来的最近时刻是 19:39，是 5 分钟之后。结果不是 19:33 因为这个时刻是 23 小时 59 分钟之后。
 *  
 * <p>
 * 样例 2:
 * <p>
 * 输入: "23:59"
 * 输出: "22:22"
 * 解释: 利用数字 2, 3, 5, 9 构造出来的最近时刻是 22:22。 答案一定是第二天的某一时刻，所以选择可构造的最小时刻。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-closest-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No681 {
    public static void main(String[] args) {
        System.out.println(new Solution681().nextClosestTime("15:55"));
    }
}

class Solution681 {
    public static final int N = 10;

    public String nextClosestTime(String time) {
        boolean[] hash = new boolean[N];
        for (char c : time.toCharArray()) {
            if (Character.isDigit(c)) {
                hash[c - '0'] = true;
            }
        }

        Map<Character, Integer> byChar = new HashMap<>();
        Map<Integer, Character> byInt = new HashMap<>();

        for (int i = 0, j = 1; i < N; ++i) {
            if (hash[i]) {
                byChar.put((char) (i + '0'), j);
                byInt.put(j, (char) (i + '0'));
                j++;
            }
        }

        int max = byChar.size();
        int min = 1;
        if (byChar.get(time.charAt(4)) < max) {
            return time.substring(0, time.length() - 1) + byInt.get(byChar.get(time.charAt(4)) + 1);
        }

        if (byChar.get(time.charAt(3)) < max) {
            int temp = Integer.parseInt("" + byInt.get(byChar.get(time.charAt(3)) + 1) + byInt.get(min));
            if (temp < 60) {
                return time.substring(0, 3) + String.format("%02d", temp);
            }
        }

        if (byChar.get(time.charAt(1)) < max) {
            int temp = Integer.parseInt("" + time.charAt(0) + byInt.get(byChar.get(time.charAt(1)) + 1));
            if (temp < 24) {
                return String.format("%02d", temp) + ':' + byInt.get(min) + byInt.get(min);
            }
        }

        if (byChar.get(time.charAt(0)) < max) {
            int temp = Integer.parseInt("" + byInt.get(byChar.get(time.charAt(0)) + 1) + byInt.get(min));
            if (temp < 24) {
                return String.format("%02d", temp) + ':' + byInt.get(min) + byInt.get(min);
            }
        }
        return "" + byInt.get(min) + byInt.get(min) + ':' + byInt.get(min) + byInt.get(min);
    }
}