package leetcode.again.L446_ArithmeticSlicesIISubsequence;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 3:45 PM 3/3/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }

                int d = (int) diff;
                int c = maps[j].getOrDefault(d, 0);
                count += c;
                maps[i].put(d, maps[i].getOrDefault(d, 0) + c + 1);
            }
        }
        return count;
    }
}
