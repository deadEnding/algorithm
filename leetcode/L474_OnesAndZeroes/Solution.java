package leetcode.L474_OnesAndZeroes;

/**
 * @author: deadend
 * @date: 9:39 PM 12/24/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    private int[] count(String s) {
        int[] counter = new int[2];
        for (char c : s.toCharArray()) {
            counter[c - '0']++;
        }
        return counter;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] counter = count(s);
            for (int i = m; i >= counter[0]; i--) {
                for (int j = n; j >= counter[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - counter[0]][j - counter[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

class TimeoutSolution {
    private int max = 0;

    private void dfs(int ix, String[] strs, int m, int n, int count) {
        if (ix == strs.length) {
            max = Math.max(max, count);
            return;
        }

        int znum = 0;
        for (char c : strs[ix].toCharArray()) {
            znum += c == '0' ? 1 : 0;
        }

        if (m >= znum && n >= strs[ix].length() - znum) {
            dfs(ix + 1, strs, m - znum, n - (strs[ix].length() - znum), count + 1);
        }
        dfs(ix + 1, strs, m, n, count);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        dfs(0, strs, m, n, 0);
        return max;
    }

    public static void main(String[] args) {
        String[] strs = {"P10", "0", "1"};
        int m = 1;
        int n = 1;
        System.out.println(new Solution().findMaxForm(strs, m, n));
    }
}
