package leetcode.L452_MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: deadend
 * @date: 5:50 PM 12/23/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int count = 1;
        for (int i = 1, min = points[0][1]; i < points.length; i++) {
            if (points[i][0] <= min) {
                min = Math.min(min, points[i][1]);
            } else {
                count++;
                min = points[i][1];
            }
        }
        return count;
    }
}

class BasicSolution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int count = 0;
        long min = Integer.MAX_VALUE + 1L;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] >= min) {
                count++;
                if (points[i][0] > min) {
                    min = points[i][1];
                } else {
                    while (i < points.length && points[i][0] == min) {
                        i++;
                    }
                    if (i == points.length) {
                        return count;
                    }
                    min = points[i][1];
                }
            } else {
                min = Math.min(min, points[i][1]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3}, {1,4}, {1,3}, {3,7}};
        System.out.println(new Solution().findMinArrowShots(points));
    }
}
