package leetcode.again.L096_UniqueBinarySearchTrees;


public class Solution {
    public int numTrees(int n) {
        if (n == 0)
            return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}


class BasicSolution {
    private int numTrees(int s, int e, int[] cache) {
        if (s >= e) {
            return 1;
        }

        int len = e - s + 1;
        if (cache[len] == 0) {
            for (int i = s; i <= e; i++) {
                cache[len] += numTrees(s, i - 1, cache) * numTrees(i + 1, e, cache);
            }
        }
        return cache[len];
    }

    public int numTrees(int n) {
        if (n == 0)
            return 0;

        return numTrees(1, n, new int[n + 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}
