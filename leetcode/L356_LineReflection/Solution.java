package leetcode.L356_LineReflection;

import java.util.HashSet;

/**
 * @author: deadend
 * @date: 9:07 PM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private String hash(int x, int y) {
        return x + "|" + y;
    }

    public boolean isReflected(int[][] points) {
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] p : points) {
            minx = Math.min(minx, p[0]);
            maxx = Math.max(maxx, p[0]);
            set.add(hash(p[0], p[1]));
        }

        int sum = minx + maxx;
        for (int[] p : points) {
            String h = hash(sum - p[0], p[1]);
            if (!set.contains(h)) {
                return false;
            }
        }
        return true;
    }
}

class BasicSolution {
    private String hash(int x, int y) {
        return x + "|" + y;
    }

    public boolean isReflected(int[][] points) {
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        for (int[] p : points) {
            minx = Math.min(minx, p[0]);
            maxx = Math.max(maxx, p[0]);
        }

        int k2 = minx + maxx;
        HashSet<String> setLeft = new HashSet<>();
        HashSet<String> setRight = new HashSet<>();
        for (int[] p : points) {
            if (p[0] * 2 > k2) {
                setRight.add(hash(k2 - p[0], p[1]));
            } else if (p[0] * 2 < k2) {
                setLeft.add(hash(p[0], p[1]));
            }
        }

        for (String sl : setLeft) {
            if (!setRight.remove(sl)) {
                return false;
            }
        }
        return setRight.size() == 0;
    }

    public static void main(String[] args) {
        int[][] p = {{-16,1},{16,1},{16,1}};
        System.out.println(new Solution().isReflected(p));
    }
}
