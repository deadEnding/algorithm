package leetcode.L218_TheSkylineProblem;

import java.util.*;

/**
 * @author: deadend
 * @date: 4:52 PM 2/15/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[] {b[0], b[2]});
            heights.add(new int[] {b[1], -b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

        List<int[]> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int prevHeight = 0;
        map.put(0, 1);
        for (int[] h : heights) {
            if (h[1] > 0) {
                map.put(h[1], map.getOrDefault(h[1], 0) + 1);
            } else {
                map.put(-h[1], map.get(-h[1]) - 1);
                if (map.get(-h[1]) == 0) {
                    map.remove(-h[1]);
                }
            }

            int maxHeight = map.lastKey();
            if (maxHeight != prevHeight) {
                result.add(new int[] {h[0], maxHeight});
                prevHeight = maxHeight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] b = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        List<int[]> result = new Solution().getSkyline(b);
        for (int[] p : result) {
            System.out.println(p[0] + "  " + p[1]);
        }
    }
}
