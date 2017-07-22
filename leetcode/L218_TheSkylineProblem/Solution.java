package leetcode.L218_TheSkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: deadend
 * @date: 1:11 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        final int n = buildings.length;
        ArrayList<int[]> xh = new ArrayList<>();
        for (int[] b : buildings) {
            xh.add(new int[] {b[0], b[2]});
            xh.add(new int[] {b[1], -b[2]});
        }

        Collections.sort(xh, (h1, h2) -> (h1[0] != h2[0] ? h1[0] - h2[0] : h2[1] - h1[1]));

        TreeMap<Integer, Integer> hc = new TreeMap<>();
        hc.put(0, 1);

        List<int[]> result = new ArrayList<>();
        int lastHeight = 0;
        for (int[] h : xh) {
            if (h[1] > 0) {
                hc.put(h[1], hc.getOrDefault(h[1], 0) + 1);
            } else {
                hc.put(-h[1], hc.get(-h[1]) - 1);
                if (hc.get(-h[1]) == 0) {
                    hc.remove(-h[1]);
                }
            }

            int maxHeight = hc.lastKey();
            if (lastHeight != maxHeight) {
                result.add(new int[] {h[0], maxHeight});
                lastHeight = maxHeight;
            }
        }

        return result;
    }
}





class FirstSolution {
    public List<int[]> getSkyline(int[][] buildings) {
        final int n = buildings.length;
        ArrayList<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[] {b[0], b[2]});
            heights.add(new int[] {b[1], -b[2]});
        }

        Collections.sort(heights, (h1, h2) -> (h1[0] != h2[0] ? h1[0] - h2[0] : h2[1] - h1[1]));

        List<int[]> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int prevHeight = 0;
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
            if (prevHeight != maxHeight) {
                result.add(new int[] {h[0], maxHeight});
                prevHeight = maxHeight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] b = {{1,2,5}, {1,2,4}};
        List<int[]> ps = new Solution().getSkyline(b);
        for (int[] p : ps) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}
