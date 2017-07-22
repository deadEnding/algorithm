package leetcode.L401_BinaryWatch;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 2:25 PM 3/16/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private String convert(int val) {
        int h = val >> 6;
        int m = val & 0b11_1111;
        if (h >= 12 || m >= 60) {
            return null;
        }

        return String.format("%d:%02d", h, m);
    }

    private void backtracking(int ix, int val, int zeroCount, List<String> result) {
        if (zeroCount == 0) {
            String s = convert(val);
            if (s != null) {
                result.add(s);
            }
            return;
        }

        if (ix == 12) {
            return;
        }

        backtracking(ix + 1, val | (1 << ix), zeroCount - 1, result);
        backtracking(ix + 1, val, zeroCount, result);
    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new LinkedList<>();
        backtracking(0, 0, num, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
    }
}


class BasicSolution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new LinkedList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) + m) == num) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }
}
