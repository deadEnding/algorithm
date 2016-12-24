package leetcode.L455_AssignCookies;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 11:06 AM 12/24/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}

class BasicSolution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            count += j < s.length ? 1 : 0;
        }
        return count;
    }
}
