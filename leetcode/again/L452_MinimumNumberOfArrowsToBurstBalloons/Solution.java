package leetcode.again.L452_MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: P10:18 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> (p1[0] - p2[0]));
        int count = 0;
        long end = Integer.MIN_VALUE - 1L;
        for (int[] p : points) {
            if (p[0] <= end) {
                end = Math.min(end, p[1]);
            } else {
                count++;
                end = p[1];
            }
        }
        return count;
    }
}


class FirstSolution {
    public int findMinArrowShots(int[][] points) {
        final int n = points.length;
        if (n == 0)
            return 0;

        Arrays.sort(points, (p1, p2) -> (p1[0] - p2[0]));
        int count = 0;
        for (int i = 0, min = Integer.MAX_VALUE; i < n; i++) {
            if (points[i][0] > min) {
                count++;
                min = points[i][1];
            } else {
                min = Math.min(min, points[i][1]);
            }
        }
        return count + 1;
    }
}
