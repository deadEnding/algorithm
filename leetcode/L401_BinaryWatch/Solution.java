package leetcode.L401_BinaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:41 AM 12/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) + m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(2));
    }
}
