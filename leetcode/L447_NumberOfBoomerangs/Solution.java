package leetcode.L447_NumberOfBoomerangs;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 12:00 PM 11/26/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        final int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> distCount = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int d = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                distCount.put(d, distCount.containsKey(d) ? distCount.get(d) + 1 : 1);
            }

            for (int c : distCount.values()) {
                count += c >= 2 ? c * (c - 1) : 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0}, {1,0}, {2,0}};
        System.out.println(new Solution().numberOfBoomerangs(points));
    }
}
