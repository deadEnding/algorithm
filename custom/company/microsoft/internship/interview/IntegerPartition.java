package custom.company.microsoft.internship.interview;

import java.util.HashMap;
import java.util.LinkedList;

public class IntegerPartition {

    public void dfs0(int n, int m, LinkedList<Integer> path) {
        if (n == 0) {
            for (int i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        if (m == 0) {
            return;
        }

        for (int i = n / m; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                path.addLast(m);
            }

            dfs0(n - i * m, m - 1, path);

            for (int j = 0; j < i; j++) {
                path.removeLast();
            }
        }
    }


    // stackoverflow when n is too large
    public int dfs1(int n, int m, HashMap<String, Integer> cache) {
        String key = n + "|" + m;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (n == 0) {
            return 1;
        }

        if (m == 0) {
            return 0;
        }

        int count = 0;
        for (int i = n / m; i >= 0; i--) {
            count += dfs1(n - i * m, m - 1, cache);
        }
        cache.put(key, count);
        return count;
    }

    public int dpsolve(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= i / j; k++) {
                    dp[i][j] += dp[i - k * j][j - 1];
                }
            }
        }

        return dp[n][n];
    }


    public void solve(int n) {
//        dfs0(n, n, new LinkedList<>());
//        int cnt = dfs1(n, n, new HashMap<>());
        int cnt = dpsolve(n);
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        new IntegerPartition().solve(6);
    }
}
